public class DrawView extends android.support.v7.widget.AppCompatImageView {
    private ArrayList<ColouredPoint> mTouches;
    // Current used colour
    private int mCurrColour;
    private Paint mPaint;

    public void setColor(int colour) {
        mCurrColour = colour;
    }

    public DrawView(Context context) {
        super(context);
        init();
    }

    // XML constructor
    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        mTouches = new ArrayList<>();
        mPaint = new Paint();
        mPaint.setColor(mCurrColour);
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(5);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mPaint.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        // Capture a reference to each touch for drawing
        float touchX = event.getX();
        float touchY = event.getY();
        mTouches.add(new ColouredPoint(Math.round(touchX), Math.round(touchY), mCurrColour));

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas c) {
        // Let the image be drawn first
        super.onDraw(c);
        // Draw your custom points here
        for (ColouredPoint p : mTouches) {
            mPaint.setColor(p.colour);
            c.drawCircle(p.x, p.y, 15, mPaint);
        }
    }

    /**
     * Class to store the coordinate and the colour of the point.
     */
    private class ColouredPoint {
        int x;
        int y;
        int colour;

        public ColouredPoint(int x, int y, int colour) {
            this.x = x;
            this.y = y;
            this.colour = colour;
        }
    }
}