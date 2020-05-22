class FL extends FrameLayout {
    private List<View> mViews = new ArrayList<View>();
    private Bitmap mBack;
    private Bitmap mBackBlur;
    private int[] mLocation = new int[2];
    private Matrix mMatrix = new Matrix();

    public FL(Context context) {
        super(context);
        Resources res = getResources();
        mBack = BitmapFactory.decodeResource(res, R.drawable.back);
        mBackBlur = BitmapFactory.decodeResource(res, R.drawable.back_blur);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        RectF src = new RectF(0, 0, mBack.getWidth(), mBack.getHeight());
        RectF dst = new RectF(0, 0, w, h);
        mMatrix.setRectToRect(src, dst, ScaleToFit.FILL);
    }

    public void add(View v) {
        mViews.add(v);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.drawBitmap(mBack, mMatrix, null);

        canvas.save(Canvas.CLIP_SAVE_FLAG);
        getLocationOnScreen(mLocation);
        int x = mLocation[0];
        int y = mLocation[1];
        Op op = Op.REPLACE;
        for (View v : mViews) {
            v.getLocationOnScreen(mLocation);
            mLocation[0] -= x;
            mLocation[1] -= y;

            int left = mLocation[0];
            int top = mLocation[1];
            int right = left + v.getWidth();
            int bottom = top + v.getHeight();
            canvas.clipRect(left, top, right, bottom, op);
            op = Op.UNION;
        }
        canvas.drawBitmap(mBackBlur, mMatrix, null);
        canvas.restore();
        super.dispatchDraw(canvas);
    }
}