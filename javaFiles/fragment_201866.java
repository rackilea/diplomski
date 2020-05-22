public class TickedProgressBarView extends ProgressBar {

    private static final float DEFAULT_INTERVAL = 25f;
    private float INDICATOR_RADIUS;
    private Paint mTickPaint;
    private float mInterval; //%

    public TickedProgressBarView(Context context) {
        super(context);
        initPainters(context, null); //because draw is called a lot of times, don't want to do loads of allocations in onDraw
    }

    public TickedProgressBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
         initPainters(context, attrs);
    }

    public TickedProgressBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initPainters(context, attrs);
    }

    private void initPainters(Context context, @Nullable AttributeSet attrs) {
        if (attrs != null) {
            TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.TickedProgressBarView, 0, 0);
            mInterval = a.getFloat(R.styleable.TickedProgressBarView_tickInterval, DEFAULT_INTERVAL);
        } else {
            mInterval = DEFAULT_INTERVAL;
        }
        //5 on the line below is HALF how many Dp wide you want the circles - ie a 10 Dp circle results from this
        INDICATOR_RADIUS = 5 * getResources().getDisplayMetrics().density + 0.5f;
        mTickPaint = new Paint();
        mTickPaint.setColor(ContextCompat.getColor(getContext(), R.color.my_color));
        mTickPaint.setStyle(Paint.Style.FILL);
        mTickPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    public void setTickInterval(float intervalPercentage) {
        mInterval = intervalPercentage;
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (mInterval > 0f) {
            final float midHeight = canvas.getHeight() / 2f;
            final int end = canvas.getWidth();
            final int intervalPx = (int) ((end / 100f) * mInterval);
            int nextInterval = intervalPx;
            while (nextInterval <= end) {
                canvas.drawCircle(nextInterval, midHeight, INDICATOR_RADIUS, mTickPaint);
                nextInterval += intervalPx;
            }
        }
    }

}