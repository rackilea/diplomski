public static void fadeLayoutColour(RelativeLayout rLayout, long timeMills) {
    final ThreadLocalRandom r = ThreadLocalRandom.current();
    final ObjectAnimator colourFade = ObjectAnimator.ofObject(rLayout, "backgroundColor", new ArgbEvaluator(),
            Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)),
            Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)));
    colourFade.setDuration(timeMills);
    colourFade.setRepeatCount(Animation.INFINITE);
    colourFade.addListener(new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {}

        @Override
        public void onAnimationEnd(Animator animation) {}

        @Override
        public void onAnimationCancel(Animator animation) {           }

        @Override
        public void onAnimationRepeat(Animator animation) {
            colourFade.setObjectValues(colourFade.getAnimatedValue(),
                    Color.argb(255, r.nextInt(256), r.nextInt(256), r.nextInt(256)));
        }
    });
    colourFade.start();
}