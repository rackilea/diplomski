ValueAnimator anim = ValueAnimator.ofInt(viewToIncreaseHeight.getMeasuredHeight(), -100);
anim.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
    @Override
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        int val = (Integer) valueAnimator.getAnimatedValue();
        ViewGroup.LayoutParams layoutParams = viewToIncreaseHeight.getLayoutParams();
        layoutParams.height = val;
        viewToIncreaseHeight.setLayoutParams(layoutParams);
    }
});
anim.setDuration(DURATION);
anim.start();