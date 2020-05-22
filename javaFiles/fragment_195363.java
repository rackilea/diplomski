class V extends View {
    Bitmap tileBitmap;
    Bitmap lightBitmap;
    RectF lightRect;
    Paint paint0 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);

    public V(Context context) {
        super(context);
//        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        tileBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fykgf);
        lightBitmap = Bitmap.createBitmap(256, 256, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(lightBitmap);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        p.setMaskFilter(new BlurMaskFilter(20, BlurMaskFilter.Blur.NORMAL));
        c.drawCircle(128, 128, 100, p);
        lightRect = new RectF(0, 0, lightBitmap.getWidth(), lightBitmap.getHeight());
        lightRect.offset(200, 200);

        float[] array = {
                4, 0, 0, 0, 0,
                0, 4, 0, 0, 0,
                0, 0, 0, 0, 0,
                0, 0, 0, 1, 0,
        };
        paint0.setColorFilter(new ColorMatrixColorFilter(array));
        paint1.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        drawTiles(canvas, null);

        canvas.saveLayer(lightRect, null, Canvas.HAS_ALPHA_LAYER_SAVE_FLAG);
        canvas.clipRect(lightRect);
        drawTiles(canvas, paint0);
        canvas.drawBitmap(lightBitmap, null, lightRect, paint1);
        canvas.restore();
    }

    void drawTiles(Canvas canvas, Paint p) {
        // draw your Bitmaps here...
    }
}