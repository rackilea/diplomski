@SuppressLint("NewApi")
public class Clock extends View {

    private Drawable mHourHand;
    private Drawable mMinuteHand;

    private Drawable Hh;
    private Drawable Mh;

    private boolean mAttached;

    static private float mMinutes = 43;
    static private float mHour = 5;

    Context mContext;

    // Getters&setters

    protected float getmMinutes() {
        return mMinutes;
    }

    protected static void setmMinutes(float mMinutes) {
        Clock.mMinutes = mMinutes;
    }

    protected float getmHour() {
        return mHour;
    }

    protected static void setmHour(float mHour) {
        Clock.mHour = mHour;
    }

    // Ctors

    {
        initView();
    }

    public Clock(Context context) {
        super(context);
    }

    public Clock(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public Clock(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    private void initView() {
        Resources r = getContext().getResources();
        mContext            = getContext();
        Hh                  = r.getDrawable(R.drawable.hours);
        Mh                  = r.getDrawable(R.drawable.minuts);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

        if (!mAttached) {
            mAttached = true;
            IntentFilter filter = new IntentFilter();

            filter.addAction(Intent.ACTION_TIME_TICK);
            filter.addAction(Intent.ACTION_TIME_CHANGED);
            filter.addAction(Intent.ACTION_TIMEZONE_CHANGED);

        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int w               = r - l;
        int h               = b - t;

        mHourHand           = Hh;
        mMinuteHand         = Mh;

        // They will always be drawn centered inside the view
        mHourHand.setBounds(
                (w - mHourHand.getIntrinsicWidth()) / 2,
                (h - mHourHand.getIntrinsicHeight()) / 2,
                (w + mHourHand.getIntrinsicWidth()) / 2,
                (h + mHourHand.getIntrinsicHeight()) / 2
        );
        mMinuteHand.setBounds(
                (w - mMinuteHand.getIntrinsicWidth()) / 2,
                (h - mMinuteHand.getIntrinsicHeight()) / 2,
                (w + mMinuteHand.getIntrinsicWidth()) / 2,
                (h + mMinuteHand.getIntrinsicHeight()) / 2
        );
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        // Rotate the center of the view (here the canvas is clipped and translated so that its clipped bounds are these of this view).
        canvas.save();
        canvas.rotate(mHour * 360/12, getWidth()/2, getHeight()/2);
        mHourHand.draw(canvas);
        canvas.restore();

        canvas.save();
        canvas.rotate(mMinutes * 360/12, getWidth()/2, getHeight()/2);
        mMinuteHand.draw(canvas);
        canvas.restore();
    }
}