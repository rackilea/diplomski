private void fadeIn() {
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mButton, "alpha", 0f, 1f);
    objectAnimator.setDuration(500L);
    objectAnimator.addListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
            fadeOut();
        }
    });
    objectAnimator.start();
}

private void fadeOut() {
    ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(mButton, "alpha", 1f, 0f);
    objectAnimator.setDuration(500L);
    objectAnimator.addListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
            fadeIn();
        }
    });
    objectAnimator.start();
}