public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
   int halfWidth = getWindow().getDecorView().getWidth() / 2;
    if (e1.getX() < halfWidth) {
      //leftSide code
    else{
      //rightSide code
    }
}