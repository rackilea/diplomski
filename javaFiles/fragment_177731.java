public class IdleFlag {
  private boolean idle;

  public void waitUntilIdle() throws InterruptedException {
    synchronized (this) {
      while (true) {
        // If the flag is set, we're done.
        if (this.idle) { break; }
        // Go to sleep until another thread notifies us.
        this.wait();
      }
    }
  }

  public void setIdle() {
    synchronized (this) {
      this.idle = true;
      // Causes all waiters to wake up.
      this.notifyAll();
    }
  }
}