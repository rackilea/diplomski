@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    // After GridView measured everything, see if height needs update
    int desiredHeight = getMeasuredHeight();
    desiredHeight = Math.max(desiredHeight, getSuggestedMinimumHeight());
    setMeasuredDimension(getMeasuredWidth(), desiredHeight);
}