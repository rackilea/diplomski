class process implements Runnable {
  // note that this is static
  private static final Object lock = new Object();

  public void processTest() {
    synchronized(lock) {
      // your code
    }
  }
}