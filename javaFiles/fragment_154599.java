int color = Color.BLUE;
postDelayed(new Runnable() {
    @Override
    public void run() {
        color = (color == Color.BLUE) ? Color.Black : Color.BLUE;
        invalidate();
        postDelayed(this, 100);
    }
}, 100);

@Override
protected void onDraw(Canvas canvas) {
    this.mFilledPaint.setColor(color);
    canvas.drawCircle(x, y, radius, mFilledPaint);
}