private Animation outToRightAnimation() {
    Animation outtoRight = new TranslateAnimation( Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, +1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
    outtoRight.setDuration(500);
    outtoRight.setInterpolator(new AccelerateInterpolator());
    return outtoRight;
}