@Override
protected void onMeasure( int widthMeasureSpec, int heightMeasureSpec )
{   
    int p_top = this.getPaddingTop(), p_bottom = this.getPaddingBottom();

    // Calculate new desired height
    final int desiredHSpec = MeasureSpec.makeMeasureSpec( mHeight + p_top + p_bottom , MeasureSpec.EXACTLY );

    setMeasuredDimension( widthMeasureSpec, desiredHSpec );
    super.onMeasure( widthMeasureSpec, desiredHSpec );

    // Update the draw left position
    mDrawLeftPos = Math.max( ( this.getWidth() - mWidth ) / 2, 0) ;
}