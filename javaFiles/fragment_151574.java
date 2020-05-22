private TimerTask timerOneTask(int sleepTime) {
  return new DoNothingTimerTask extends TimerTask {
      public void run() {
        try {
          Thread.sleep(sleepTime);
        } catch (InterruptedException e) {
          // awoken prematurely, handle this
      }
  }
}