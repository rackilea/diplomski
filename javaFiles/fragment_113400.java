public class SensorView extends View {

    private float mReading;  // I use float as an example; use whatever your sensor device supports
    private Bitmap mBitmap;
    private Matrix mMatrix;
    private RectF mBitmapRect;
    private RectF mViewRect;

    public SensorView(Context context) {
        this(context, null);
    }

    public SensorView(Context context, AttributeSet attrs) {
        super(context, attrs);

        // set up your Bitmap here; don't worry about scaling it yet
        mBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sensor_bitmap);

        mMatrix = new Matrix();
        mBitmapRect = new RectF(0, 0, mBitmap.getWidth(), mBitmap.getHeight());
        mViewRect = new RectF();
    }

    public void setReading(float reading) {
        mReading = reading;
        postInvalidate();   // refresh the display
    }

    @Override
    public void onDraw(Canvas canvas) {

        mViewRect.right = getWidth();
        mViewRect.bottom = getHeight();
        mMatrix.reset();

        // center and scale the image
        mMatrix.setRectToRect(mBitmapRect, mViewRect, ScaleToFit.CENTER);

        // do the rotation
        float theta = ... // compute angle based on mReading
        mMatrix.preRotate(theta, mBitmapRect.centerX(), mBitmapRect.centerY());

        // draw the bitmap with the matrix
        canvas.drawBitmap(mBitmap, mMatrix, null);
    }
}