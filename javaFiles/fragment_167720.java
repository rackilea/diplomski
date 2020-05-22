public class PrioLock {
  private boolean _locked;
  private boolean _priorityWaiting;

  public synchronized void lock() throws InterruptedException {
    while(_locked || _priorityWaiting) {
      wait();
    }
    _locked = true;
  }

  public synchronized void lockPriority() throws InterruptedException {
    _priorityWaiting = true;
    try {
      while(_locked) {
          wait();
      }
      _locked = true;
    } finally {
      _priorityWaiting = false;
    }
  }

  public synchronized void unlock() {
    _locked = false;
    notifyAll();
  }
}