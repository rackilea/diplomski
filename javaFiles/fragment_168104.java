public void runMin(int minutes) {
   cminute.startAnimation(createAnimation(minutes*6));
}

public void runSec(int seconds) {
  csecond.startAnimation(createAnimation(seconds*6));
}

public RotateAnimation createAnimation(int time) {
   RotateAnimation rotateAnimation = new RotateAnimation(time, time,
   Animation.RELATIVE_TO_SELF, 0.5f,Animation.RELATIVE_TO_SELF, 0.5f);
   rotateAnimation.setFillAfter(true);
   return rotateAnimation;
}