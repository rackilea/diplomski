public class ClippedImageView extends ImageView {
    private Paint mPaint;
    private Path mPath;

    public ClippedImageView(Context context) {
        this(context, null);
        init();
    }

    public v(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public ClippedImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        mPath = new Path();
        RectF rect = new RectF(0, 0, 100, 100);
        mPath.addArc(rect, 270, 180);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.clipPath(mPath, Region.Op.DIFFERENCE);
        super.onDraw(canvas);
    }
}