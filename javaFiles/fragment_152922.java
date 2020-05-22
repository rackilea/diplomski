private final Object lockObject = new Object();
  public void run() {
     synchronized (lockObject) {
        ...
        lockObject.wait();
     }
  }

  // called by another thread
  public void operationRequired() {
     synchronized (lockObject) {
        ...
        lockObject.notify();
     }
  }