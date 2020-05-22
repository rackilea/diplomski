AlphaAnimation anim = new AlphaAnimation(0.0f, 1.0f);
anim.setDuration(4000);
anim.setRepeatMode(Animation.REVERSE);
anim.setAnimationListener(new Animation.AnimationListener() {
    @Override
    public void onAnimationStart(Animation animation) {
        btnTag.setClickable(false);
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        btnTag.setClickable(true);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {}
});
btnTag.startAnimation(anim);