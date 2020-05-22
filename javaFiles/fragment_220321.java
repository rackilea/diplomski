final AnimatorSet set = new AnimatorSet();
set.playSequentially(set1, set2);

set.addListener(new AnimatorListenerAdapter() {
    @Override
    public void onAnimationEnd(Animator animation) {
        fab.setClickable(true);
    }

    @Override
    public void onAnimationStart(Animator animation) {
        fab.setClickable(false);
    }
});