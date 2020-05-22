@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int width = getResources().getDisplayMetrics().widthPixels >> 1;
    widthMeasureSpec = MeasureSpec.makeMeasureSpec(width, MeasureSpec.EXACTLY);
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
}