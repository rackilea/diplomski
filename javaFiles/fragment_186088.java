// This animation rotates and hides the top Button
final Animator hideTopFabAnimation = ObjectAnimator.ofPropertyValuesHolder(fabAdd,
        PropertyValuesHolder.ofFloat(View.ALPHA, 1.0f, 0.0f),
        PropertyValuesHolder.ofFloat(View.ROTATION, 0.0f, 360.0f)
);

// This animation just rotates the bottom Button while it is being revealed
final Animator revealBottomFabAnimation = ObjectAnimator.ofPropertyValuesHolder(fabEdit,
        PropertyValuesHolder.ofFloat(View.ROTATION, 0.0f, 360.0f)
);

// This AnimatorSet combines both animations and also has a listener 
// attached to set the visibility of the top Button to View.GONE when
// the animation is done so the user can actually click through to the 
// lower Button
final AnimatorSet revealAnimation = new AnimatorSet();
revealAnimation.setInterpolator(new AccelerateDecelerateInterpolator());
revealAnimation.playTogether(
        hideTopFabAnimation,
        revealBottomFabAnimation
);
revealAnimation.addListener(new AnimatorListenerAdapter() {
    @Override
    public void onAnimationEnd(Animator animation) {
        super.onAnimationEnd(animation);
        fabAdd.setVisibility(View.GONE);
    }
});
revealAnimation.start();