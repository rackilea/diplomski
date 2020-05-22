private Animation inFromLeftAnimation() {
    Animation inFromLeft = new TranslateAnimation( Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
    inFromLeft.setDuration(500);
    inFromLeft.setInterpolator(new AccelerateInterpolator());
    return inFromLeft;
}