public static void waitForThread() {
  monitorState = true;
  while (monitorState) {
    synchronized (monitor) {
      try {
        monitor.wait(); // wait until notified
      } catch (Exception e) {}
    }
  }
}