public MyView(Context c) {
        super(c);

        mPath = new Path();
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);
    }

    public MyView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        mPath = new Path();
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);
    }


    public MyView(Context context, AttributeSet attrs ) {
        super(context, attrs);
        mPath = new Path();
        mBitmapPaint = new Paint(Paint.DITHER_FLAG);
    }