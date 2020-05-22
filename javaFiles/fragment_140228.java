new Thread() {
  public void run() {
    synchronized (reqSync) {
      // ...
    }
  }
}