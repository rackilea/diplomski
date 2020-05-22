public final class BarView extends View {

    private final Paint mPaint = new Paint();
    private int percent = 0;

    public BarView(Context context) {
        super(context);
        init();
    }

    public BarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public BarView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setAntiAlias(true);
    }

    public void set(int color, int percent) {

        if(percent < 0 || percent > 100) {
            throw new IllegalArgumentException("Percent value must range from 0 to 100");
        }

        mPaint.setColor(color);
        this.percent = percent;
        invalidate();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final float width = MeasureSpec.getSize(widthMeasureSpec);
        final float adjWidth = (width*((float)percent/100));
        setMeasuredDimension((int)adjWidth, heightMeasureSpec);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawRect(0,0,getWidth(),getHeight(),mPaint);
    }

}