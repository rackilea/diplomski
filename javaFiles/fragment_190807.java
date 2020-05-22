ObjectAnimator anim = ObjectAnimator.ofObject(paint, "color", new ArgbEvaluator(), startColor, endColor);
anim.setDuration(1500);
anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
  @Override
  public void onAnimationUpdate(ValueAnimator animation) {
    invalidate();
  }
});

anim.start();