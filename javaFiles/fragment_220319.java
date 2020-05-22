final float from = 1.0f;
final float to = 1.3f;

ObjectAnimator scaleX = ObjectAnimator.ofFloat(fab, View.SCALE_X, from, to);
ObjectAnimator scaleY = ObjectAnimator.ofFloat(fab, View.SCALE_Y,  from, to);
ObjectAnimator translationZ = ObjectAnimator.ofFloat(fab, View.TRANSLATION_Z, from, to);

AnimatorSet set1 = new AnimatorSet();
set1.playTogether(scaleX, scaleY, translationZ);
set1.setDuration(100);
set1.setInterpolator(new AccelerateInterpolator());

set1.addListener(new AnimatorListenerAdapter() {
    @Override
    public void onAnimationEnd(Animator animation) {
        fab.setImageResource(isActive ? R.drawable.heart_active : R.drawable.heart_passive);
        fab.setBackgroundTintList(ColorStateList.valueOf(isActive ? colorActive : colorPassive));
        isActive = !isActive;
    }
});