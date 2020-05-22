textViewFractionIn.animate()
    .alpha(0.0f)
    .setListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            textViewFractionIn.setVisibility(View.GONE);
            }
        });