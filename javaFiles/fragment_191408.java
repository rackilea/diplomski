private Animation outToLeftAnimation() {
    Animation outtoLeft = new TranslateAnimation( Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, -1.0f, Animation.RELATIVE_TO_PARENT, 0.0f, Animation.RELATIVE_TO_PARENT, 0.0f);
    outtoLeft.setDuration(500);
    outtoLeft.setInterpolator(new AccelerateInterpolator());
    return outtoLeft;
}