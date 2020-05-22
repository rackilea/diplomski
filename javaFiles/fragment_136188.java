public class SharedResource {

  private final Object signal = new Object();
  private boolean writeLocked;
  private int readerCount;

  public void write(final Object newState) throws InterruptedException {

    this.acquireWriteLock();

    try {

      // Now we know that no read and no other write is going on.
      System.out.println("Write thread has the lock.");
      this.doWrite(newState);

    } finally {
      // make sure we release the lock in any case.
      this.realeaseWriteLock();
    }

  }

  private void acquireWriteLock() throws InterruptedException {
    synchronized (this.signal) {

      // Wait until no more readers *and* no writer holds the lock.

      // To do: Insert the condition we need to wait for:

      while (/* condition here! */ ) {
        // To do: Wait for the lock-holding thread(s) to signal that they released their lock(s).
      }

      this.writeLocked = true; // Let others know that the write lock has been taken.

    }
  }

  private void realeaseWriteLock() {
    synchronized (this.signal) {

      this.writeLocked = false;

      // To do: Notify any and all other waiting threads that we released the lock!

    }
  }

  public Object read() {

    // To be done...

  }

  private void acquireReadLock() throws InterruptedException {
    synchronized (this.signal) {

      // Wait until no *writer* holds the lock.
      // To do: Insert condition we need to wait for:

      while (/* condition here! */ ) {
         // To do: Wait for the lock-holding thread(s) to signal that they released their lock(s).

      }

      // Now we know that no writer holds the lock. Acquire (another) read lock:

      this.readerCount++;

    }
  }

  private void releaseReadLock() throws InterruptedException {
    synchronized (this.signal) {

      this.readerCount--;

      // To do: Notify any threads waiting (i.e. writer threads).

      // (In fact only *required* if there are *no* more readers now because that's the only condition any thread will wait on.)

    }
  }

  private void doWrite(final Object newState) {
    // do stuff
  }

  private Object doRead() {
    return "";
  }

}