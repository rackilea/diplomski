public void setTimerToChangeColors() {  
    timer.schedule(new TimerTask() {
      @Override
      public void run() {
        // Whatever you want your ball to do to changes its colors
        setTimerToChangeColors();
      }
    }, 10*1000); // 10 seconds * 1000ms per second
}