// Set the visibility of the top Button back to VISIBLE
fabAdd.setVisibility(View.VISIBLE);

// This animation fades the top Button back in and rotates it back
final Animator showTopFabAnimation = ObjectAnimator.ofPropertyValuesHolder(fabAdd,
        PropertyValuesHolder.ofFloat(View.ALPHA, 0.0f, 1.0f),
        PropertyValuesHolder.ofFloat(View.ROTATION, 360.0f, 0.0f)
);

// This animation just rotates the bottom Button while the top Button 
// fades back in
final Animator hideBottomFabAnimation = ObjectAnimator.ofPropertyValuesHolder(fabEdit,
        PropertyValuesHolder.ofFloat(View.ROTATION, 360.0f, 0.0f)
);

// Again we have an AnimatorSet which plays both animations together
final AnimatorSet hideAnimation = new AnimatorSet();
revealAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
revealAnimation.playTogether(
        showTopFabAnimation,
        hideBottomFabAnimation
);
revealAnimation.start();