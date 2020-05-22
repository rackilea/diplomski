class CustomView extends AnyView {

  ...

  public void setBackgroundColor(int color){
    paint.setColor(color);
    invalidate();
  }

  public void animateColorChange(int startColor, int endColor) {
   ValueAnimator anim = ValueAnimator.ofInt(startColor, endColor); 
    anim.setEvaluator(new ArgbEvaluator());
    anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
        @Override
        public void onAnimationUpdate(ValueAnimator animation) {
            final int newColor = (int) animator.getAnimatedValue();
            setBackgroundColor(newColor);
        } });

    anim.start();
  }

 public void onDraw(Canvas canvas) {
    canvas.drawPaint(paint);
  }
}