@Override
protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
{
    super.onMeasure(widthMeasureSpec, heightMeasureSpec);

    if(useDefault)
        setMeasuredDimension(getMeasuredWidth(), Math.round(defaultHeight));
}