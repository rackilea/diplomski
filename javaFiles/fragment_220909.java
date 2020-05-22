display.timerExec( 1000, new Runnable() {
  public void run() {
    if( !shlClock.isDisposed() {
      pullClock();
      display.timerExec( 1000, this );
    }
  }
}