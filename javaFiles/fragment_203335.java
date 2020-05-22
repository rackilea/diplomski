public void SlideToAbove() {
    Animation slide = null;
    slide = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
            Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
            0.0f, Animation.RELATIVE_TO_SELF, -5.0f);

    slide.setDuration(400);
    slide.setFillAfter(true);
    slide.setFillEnabled(true);
    rl_layout.startAnimation(slide);

    slide.setAnimationListener(new AnimationListener() {

        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationRepeat(Animation animation) {
        }

        @Override
        public void onAnimationEnd(Animation animation) {

            rl_layout.clearAnimation();

            RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(
                    rl_layout.getWidth(), rl_layout.getHeight());
            lp.setMargins(0, 0, 0, 0);
            lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            rl_layout.setLayoutParams(lp);

        }

    });

}