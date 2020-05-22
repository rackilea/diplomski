private Animation fadeInAnimation() {
    Animation animation = new AlphaAnimation(0f, 1.0f);
    animation.setDuration(1000); // in milliseconds
    animation.setFillEnabled(true);
    animation.setFillAfter(true);
    return animation;
}