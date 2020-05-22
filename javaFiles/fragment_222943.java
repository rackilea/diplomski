public class YourNewView extends View {
private final static int TOTAL_DEGREE = 360;
private final static int START_DEGREE = -90;

private Paint mPaint;
private RectF mOvalRect = null;

private int mItemCount = 5;
private int mSweepAngle;

private int mInnerRadius;
private int mOuterRadius;
private Bitmap mCenterIcon;
private int[] mColors = {Color.RED, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN};
private String[] mTitles = {"APPT CENTER", "MEDS CABINET", "CHECK-IN", "MY TRACKERS", "MY ACCOUNTS"};


public YourNewView (Context context) {
    this(context, null);
}

public YourNewView (Context context, AttributeSet attrs) {
    this(context, attrs, 0);
}

public YourNewView (Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);

    mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    mPaint.setStrokeWidth(2);

    mSweepAngle = TOTAL_DEGREE / mItemCount;

    mInnerRadius = 125;
    mOuterRadius = 400;

    mCenterIcon = BitmapFactory.decodeResource(getResources(), R.drawable.ic_launcher);
}

@Override
protected void onDraw(Canvas canvas) {

    int width = getWidth();
    int height = getHeight();

    if (mOvalRect == null) {
        mOvalRect = new RectF(width / 2 - mOuterRadius, height / 2 - mOuterRadius, width / 2 + mOuterRadius, height / 2 + mOuterRadius);
    }

    for (int i = 0; i < mItemCount; i++) {
        int startAngle = START_DEGREE + i * mSweepAngle;
        mPaint.setColor(mColors[i]);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawArc(mOvalRect, startAngle, mSweepAngle, true, mPaint);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(mOvalRect, startAngle, mSweepAngle, true, mPaint);

        int centerX = (int) ((mOuterRadius + mInnerRadius) / 2 * Math.cos(Math.toRadians(startAngle + mSweepAngle / 2)));
        int centerY = (int) ((mOuterRadius + mInnerRadius) / 2 * Math.sin(Math.toRadians(startAngle + mSweepAngle / 2)));
        canvas.drawBitmap(mCenterIcon, width / 2 + centerX - mCenterIcon.getWidth() / 2, height / 2 + centerY - mCenterIcon.getHeight() / 2, null);

        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.FILL);
        canvas.drawText(mTitles[i], width / 2 + centerX - mCenterIcon.getWidth() / 2, height / 2 + centerY + mCenterIcon.getHeight(), mPaint);
    }

    mPaint.setColor(Color.WHITE);
    mPaint.setStyle(Paint.Style.FILL);
    canvas.drawCircle(width / 2, height / 2, mInnerRadius, mPaint);
    canvas.drawBitmap(mCenterIcon, width / 2 - mCenterIcon.getWidth() / 2, height / 2 - mCenterIcon.getHeight() / 2, null);

    super.onDraw(canvas);


   }
  }