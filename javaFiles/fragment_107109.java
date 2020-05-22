class D extends BitmapDrawable {
    private Matrix mMatrix = new Matrix();
    private int moldHeight;

    public D(Resources res, Bitmap bitmap) {
        super(res, bitmap);
    }

    @Override
    protected void onBoundsChange(Rect bounds) {
        if (bounds.height() > moldHeight) {
            moldHeight = bounds.height();
            Bitmap b = getBitmap();
            RectF src = new RectF(0, 0, b.getWidth(), b.getHeight());
            RectF dst;

            // if simpleMapping is good enough then remove "else" branch and
            // declare "dst" as:
            // RectF dst = new RectF(bounds);
            boolean simpleMapping = true;
            if (simpleMapping) {
                dst = new RectF(bounds);
            } else {
                float x = bounds.exactCenterX();
                dst = new RectF(x, 0, x, bounds.height());
                float scale = bounds.height() / src.height();
                float dx = scale * src.width() / 2;
                dst.inset(-dx, 0);
            }
            mMatrix.setRectToRect(src, dst, ScaleToFit.CENTER);
        }
    }

    @Override
    public void draw(Canvas canvas) {
        canvas.drawColor(0xaa00ff00);
        canvas.drawBitmap(getBitmap(), mMatrix, null);
    }
}