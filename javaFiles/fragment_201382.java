final TextView first = (TextView) findViewById(R.id.first);
final TextView second = (TextView) findViewById(R.id.second);

final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
animator.setRepeatCount(ValueAnimator.INFINITE);
animator.setInterpolator(new LinearInterpolator());
animator.setDuration(9000L);
animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
    @Override
    public void onAnimationUpdate(ValueAnimator animation) {
        final float progress = (float) animation.getAnimatedValue();
        final float width = first.getWidth();
        final float translationX = width * progress;
        first.setTranslationX(translationX);
        second.setTranslationX(translationX - width);
    }
});
animator.start();