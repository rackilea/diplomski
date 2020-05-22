if (blade.getAnimation() == null) {
    // no animation, start it
    blade.startAnimation(animRotate);
} else {
    //animation is showing, stop it
    blade.clearAnimation();
}