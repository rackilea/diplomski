textViewFractionIn.setVisibility(View.VISIBLE);
textViewFractionIn.animate()
    .alpha(1.0f)
    .setListener(new AnimatorListenerAdapter() {
        @Override
        public void onAnimationEnd(Animator animation) {
            super.onAnimationEnd(animation);
            // Has to be blank it seems to override the previous .setListener in the GONE case?
            }
        });