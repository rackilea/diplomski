@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    int width = MeasureSpec.getSize(widthMeasureSpec);
    int height = MeasureSpec.getSize(heightMeasureSpec);
    setMeasuredDimension(width, height);

    for(int i = 0; i < mWrapper.getChildCount(); i++) {
        View child = mWrapper.getChildAt(i);
        child.setLayoutParams(new LinearLayout.LayoutParams(width, 
        LayoutParams.FILL_PARENT));
    }

    super.onMeasure(widthMeasureSpec, heightMeasureSpec);
}