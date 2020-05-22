@Override
    protected void onDraw(Canvas canvas) {
    int viewWidthHalf = this.getMeasuredWidth() / 2; 
    int viewHeightHalf = this.getMeasuredHeight() / 2;
    int radius; 
    if (viewWidthHalf > viewHeightHalf)
        radius = viewHeightHalf - 10;
    else
        radius = viewWidthHalf - 10;

   // All lines above would go better in the onCreate Method
    paint.setStyle(Paint.Style.FILL_AND_STROKE);
    paint.setColor(backgroundColor);
    canvas.drawCircle(viewWidthHalf, viewHeightHalf, radius, paint);
    invalidate();
}