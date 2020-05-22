// Do something each second in a time frame of 60 seconds.
CountDownTimer countDownTimer = new CountDownTimer(60000, 1000) {
  public void onTick(long millisUntilFinished) {
    // For every second, do something.
    doSomething();
  }

  public void onFinish() {
    countDownTimer.start(); // restart again.
  }
}.start();