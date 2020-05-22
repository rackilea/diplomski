private static final Object counterLock = new Object();

private static volatile int counter = 0;

private void concurrentMethodRight() {
  synchronized (counterLock) {
    counter = counter + 5;
  }
  //do something
  synchronized (counterLock) {
    counter = counter - 5;
  }
}