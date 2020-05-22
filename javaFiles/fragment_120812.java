@Override
public void onBeginningOfSpeech() {
   hasSpoken=true;
   mCountDownTimer.cancel();
   timerRunning=false;
}