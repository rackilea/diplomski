public void run() {
....
  myThread.sleep(1000); 
  if (delegate != null) {
      synchronized(delegate) {
          delegate.countdownTick(i);
      }
  }
....
}