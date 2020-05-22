private ObjectAnimator objectAnimator;

private void fadeOut() {
    objectAnimator = ObjectAnimator.ofFloat(mButton, "alpha", 1f, 0f);
    objectAnimator.setDuration(500L);
    objectAnimator.addListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
            fadeIn();
        }
    });
    objectAnimator.start();
}

private void cancelAnimator() {
    if (objectAnimator != null) {
        objectAnimator.cancel();
        objectAnimator = null;
    }
}