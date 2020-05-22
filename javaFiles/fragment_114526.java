public void SlideToAbove() {
    ((RelativeLayout) findViewById(id.sMenu)).setVisibility(LinearLayout.VISIBLE);

    ObjectAnimator mover = ObjectAnimator.ofFloat(sMenu, "translationY", deltaY, 0);
    mover.setDuration(animationDuration);
    mover.start();
}

public void SlideToDown() {
    ObjectAnimator mover = ObjectAnimator.ofFloat(sMenu, "translationY", 0, deltaY);
    mover.setDuration(animationDuration);
    mover.start();
}