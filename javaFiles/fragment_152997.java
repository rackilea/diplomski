// A blocking queue I can close from the pull end. 
// Please only use put because offer does not shortcut on close.
// <editor-fold defaultstate="collapsed" desc="// Exactly what it says on the tin.">
class CloseableBlockingQueue<E> extends ArrayBlockingQueue<E> {
  // Flag indicates closed state.
  private volatile boolean closed = false;
  // All blocked threads. Actually this is all threads that are in the process
  // of invoking a put but if put doesn't block then they disappear pretty fast.
  // NB: Container is O(1) for get and almost O(1) (depending on how busy it is) for put.
  private final Container<Thread> blocked;

  // Limited size.
  public CloseableBlockingQueue(int queueLength) {
    super(queueLength);
    blocked = new Container<Thread>(queueLength);
  }

  /**
   * *
   * Shortcut to do nothing if closed.
   *
   * Track blocked threads.
   */
  @Override
  public void put(E e) throws InterruptedException {
    if (!closed) {
      Thread t = Thread.currentThread();
      // Hold my node on the stack so removal can be trivial.
      Container.Node<Thread> n = blocked.add(t);
      try {
        super.put(e);
      } finally {
        // Not blocked anymore.
        blocked.remove(n, t);
      }
    }
  }

  /**
   *
   * Shortcut to do nothing if closed.
   */
  @Override
  public E poll() {
    E it = null;
    // Do nothing when closed.
    if (!closed) {
      it = super.poll();
    }
    return it;
  }

  /**
   *
   * Shortcut to do nothing if closed.
   */
  @Override
  public E poll(long l, TimeUnit tu) throws InterruptedException {
    E it = null;
    // Do nothing when closed.
    if (!closed) {
      it = super.poll(l, tu);
    }
    return it;
  }

  /**
   *
   * isClosed
   */
  boolean isClosed() {
    return closed;
  }

  /**
   *
   * Close down everything.
   */
  void close() {
    // Stop all new queue entries.
    closed = true;
    // Must unblock all blocked threads.

    // Walk all blocked threads and interrupt them.
    for (Thread t : blocked) {
      //log("! Interrupting " + t.toString());
      // Interrupt all of them.
      t.interrupt();
    }
  }

  @Override
  public String toString() {
    return blocked.toString();
  }
}