class V extends View {
    Paint paint0;
    Paint paint1;

    public V(Context context) {
        super(context);
        setLayerType(View.LAYER_TYPE_SOFTWARE, null);
        paint0 = new Paint();
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.fykgf);
        Shader shader = new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT);
        paint0.setShader(shader);

        paint1 = new Paint();
        paint1.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));
        float[] array = {
                2, 0, 0, 0, 0,
                0, 2, 0, 0, 0,
                0, 0, 2, 0, 0, // change 2 to: something between [1..2] to get it more yellow
                0, 0, 0, 1, 0,
        };
        paint1.setColorFilter(new ColorMatrixColorFilter(array));
        paint1.setShader(shader);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint0);
        canvas.drawCircle(300, 300, 150, paint1);
    }
}