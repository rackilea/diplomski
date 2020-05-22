class LockObject {
  public synchronized void waitMethod() {
    wait();
  }

  public synchronized void notifyMethod() {
    notify();
  }
}