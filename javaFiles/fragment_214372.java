public boolean onTouchEvent(MotionEvent event) {
  if (event.getAction() == MotionEvent.ACTION_UP) {
    if(rocketAnimation.isRunning()){
      rocketAnimation.stop();
    }
  }

  if (event.getAction() == MotionEvent.ACTION_DOWN) {
    if(!rocketAnimation.isRunning()){
      rocketAnimation.start();
    }
  }
  return super.onTouchEvent(event);
}