public void setGradientColor(int endColor, int startColor) {
    GradientDrawable gradient = new GradientDrawable(Orientation.BOTTOM_TOP, new int[]  {endColor, startColor});
    gradient.setShape(GradientDrawable.RECTANGLE);
    gradient.setCornerRadius(10.f);
    btnNext.setBackgroundDrawable(gradient);
}