ObjectAnimator getScaleAnimation(View v, float scale, int duration) {
    return ObjectAnimator.ofPropertyValuesHolder(v,
        PropertyValuesHolder.ofFloat(View.SCALE_X, scale),
        PropertyValuesHolder.ofFloat(View.SCALE_Y, scale))
        .setDuration(duration);
}

AnimatorSet s = new AnimatorSet();
s.playSequentially(
    getScaleAnimation(ibOffers, 0.7f, 250),
    getScaleAnimation(ibOffers, 1.2f, 250),
    getScaleAnimation(ibOffers, 0.7f, 250),
    getScaleAnimation(ibOffers, 1.2f, 250),
    getScaleAnimation(ibOffers, 0.7f, 250),
    getScaleAnimation(ibOffers, 1.0f, 250));

s.start();