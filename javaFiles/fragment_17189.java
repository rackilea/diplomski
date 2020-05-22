public static void unlockWaiter() {
  synchronized (monitor) {
    monitorState = false;
    monitor.notifyAll(); // unlock again
  }
}