import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.EmbossMaskFilter;
import android.graphics.MaskFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by ksenchy on 29.4.2015.
 */
public class SlideToUnlock extends View {

    public interface OnSlideToUnlockEventListener {
        public void onSlideToUnlockCanceled();

        public void onSlideToUnlockDone();
    }

    private int measuredWidth, measuredHeight;
    private float density;
    private OnSlideToUnlockEventListener externalListener;
    private Paint mBackgroundPaint, mTextPaint, mSliderPaint;
    private float rx, ry; // Corner radius
    private Path mRoundedRectPath;
    private String text = "Unlock  →";

    float x;
    float event_x, event_y;
    float radius;
    float X_MIN, X_MAX;
    private boolean ignoreTouchEvents;

    // Do we cancel when the Y coordinate leaves the view?
    private boolean cancelOnYExit;
    private boolean useDefaultCornerRadiusX, useDefaultCornerRadiusY;


    /**
     * Default values *
     */
    int backgroundColor = 0xFF807B7B;
    int textColor = 0xFFFFFFFF;
    int sliderColor = 0xAA404040;


    public SlideToUnlock(Context context) {
        super(context);
        init(context, null, 0);
    }

    public SlideToUnlock(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public SlideToUnlock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    public OnSlideToUnlockEventListener getExternalListener() {
        return externalListener;
    }

    public void setExternalListener(OnSlideToUnlockEventListener externalListener) {
        this.externalListener = externalListener;
    }

    private void init(Context context, AttributeSet attrs, int style) {

        Resources res = getResources();
        density = res.getDisplayMetrics().density;

        TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.SlideToUnlock, style, 0);

        String tmp = a.getString(R.styleable.SlideToUnlock_slideToUnlockText);
        text = TextUtils.isEmpty(tmp) ? text : tmp;
        rx = a.getDimension(R.styleable.SlideToUnlock_cornerRadiusX, rx);
        useDefaultCornerRadiusX = rx == 0;
        ry = a.getDimension(R.styleable.SlideToUnlock_cornerRadiusX, ry);
        useDefaultCornerRadiusY = ry == 0;
        backgroundColor = a.getColor(R.styleable.SlideToUnlock_slideToUnlockBackgroundColor, backgroundColor);
        textColor = a.getColor(R.styleable.SlideToUnlock_slideToUnlockTextColor, textColor);
        sliderColor = a.getColor(R.styleable.SlideToUnlock_sliderColor, sliderColor);
        cancelOnYExit = a.getBoolean(R.styleable.SlideToUnlock_cancelOnYExit, false);

        a.recycle();

        mRoundedRectPath = new Path();

        mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBackgroundPaint.setStyle(Paint.Style.FILL);
        mBackgroundPaint.setColor(backgroundColor);

        mTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mTextPaint.setStyle(Paint.Style.FILL);
        mTextPaint.setColor(textColor);
        mTextPaint.setTypeface(Typeface.create("Roboto-Thin", Typeface.NORMAL));

        mSliderPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mSliderPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mSliderPaint.setColor(sliderColor);
        mSliderPaint.setStrokeWidth(2 * density);

        if (!isInEditMode()) {
            // Edit mode does not support shadow layers
            // mSliderPaint.setShadowLayer(10.0f, 0.0f, 2.0f, 0xFF000000);
            //mSliderPaint.setMaskFilter(new EmbossMaskFilter(new float[]{1, 1, 1}, 0.4f, 10, 8.2f));
            float[] direction = new float[]{0.0f, -1.0f, 0.5f};
            MaskFilter filter = new EmbossMaskFilter(direction, 0.8f, 15f, 1f);
            mSliderPaint.setMaskFilter(filter);
            //mSliderPaint.setShader(new LinearGradient(8f, 80f, 30f, 20f, Color.RED,Color.WHITE, Shader.TileMode.MIRROR));
            //mSliderPaint.setShader(new RadialGradient(8f, 80f, 90f, Color.RED,Color.WHITE, Shader.TileMode.MIRROR));
            //mSliderPaint.setShader(new SweepGradient(80, 80, Color.RED, Color.WHITE));
            //mSliderPaint.setMaskFilter(new BlurMaskFilter(15, BlurMaskFilter.Blur.OUTER));
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measuredHeight = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        measuredWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);

        if (useDefaultCornerRadiusX) {
            rx = measuredHeight * 0.52f;
        }
        if (useDefaultCornerRadiusY) {
            ry = measuredHeight * 0.52f;
        }
        mTextPaint.setTextSize(measuredHeight / 3.0f);

        radius = measuredHeight * 0.45f;
        X_MIN = 1.2f * radius;
        X_MAX = measuredWidth - X_MIN;
        x = X_MIN;

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    private void drawRoundRect(Canvas c) {
        mRoundedRectPath.reset();
        mRoundedRectPath.moveTo(rx, 0);
        mRoundedRectPath.lineTo(measuredWidth - rx, 0);
        mRoundedRectPath.quadTo(measuredWidth, 0, measuredWidth, ry);
        mRoundedRectPath.lineTo(measuredWidth, measuredHeight - ry);
        mRoundedRectPath.quadTo(measuredWidth, measuredHeight, measuredWidth - rx, measuredHeight);
        mRoundedRectPath.lineTo(rx, measuredHeight);
        mRoundedRectPath.quadTo(0, measuredHeight, 0, measuredHeight - ry);
        mRoundedRectPath.lineTo(0, ry);
        mRoundedRectPath.quadTo(0, 0, rx, 0);
        c.drawPath(mRoundedRectPath, mBackgroundPaint);
    }

    @SuppressLint("NewApi")
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (measuredHeight <= 0 || measuredWidth <= 0) {
            // There is not much we can draw :/
            return;
        }

        if (Build.VERSION.SDK_INT >= 21) {
            canvas.drawRoundRect(0, 0, measuredWidth, measuredHeight, rx, ry, mBackgroundPaint);
        }
        else {
            drawRoundRect(canvas);
        }


        // Draw the text in center
        float xPos = ((measuredWidth - mTextPaint.measureText(text)) / 2.0f);
        float yPos = (measuredHeight / 2.0f);
        float titleHeight = Math.abs(mTextPaint.descent() + mTextPaint.ascent());
        yPos += titleHeight / 2.0f;
        canvas.drawText(text, xPos, yPos, mTextPaint);


        canvas.drawCircle(x, measuredHeight * 0.5f, radius, mSliderPaint);

    }

    private void onCancel() {
        reset();
        if (externalListener != null) {
            externalListener.onSlideToUnlockCanceled();
        }
    }

    private void onUnlock() {
        if (externalListener != null) {
            externalListener.onSlideToUnlockDone();
        }
    }

    private void reset() {
        x = X_MIN;
        invalidate();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_UP:
                ignoreTouchEvents = false;
                reset();
                return true;
            case MotionEvent.ACTION_DOWN:
                // Is within the circle??
                event_x = event.getX(0);
                event_y = event.getY(0);
                double squareRadius = radius * radius;
                double squaredXDistance = (event_x - X_MIN) * (event_x - X_MIN);
                double squaredYDistance = (event_y - measuredHeight / 2) * (event_y - measuredHeight / 2);

                if (squaredXDistance + squaredYDistance > squareRadius) {
                    // User touched outside the button, ignore his touch
                    ignoreTouchEvents = true;
                }

                return true;
            case MotionEvent.ACTION_CANCEL:
                ignoreTouchEvents = true;
                onCancel();
            case MotionEvent.ACTION_MOVE:
                if (!ignoreTouchEvents) {
                    event_x = event.getX(0);
                    if (cancelOnYExit) {
                        event_y = event.getY(0);
                        if (event_y < 0 || event_y > measuredHeight) {
                            ignoreTouchEvents = true;
                            onCancel();
                        }
                    }

                    x = event_x > X_MAX ? X_MAX : event_x < X_MIN ? X_MIN : event_x;
                    if (event_x >= X_MAX) {
                        ignoreTouchEvents = true;
                        onUnlock();
                    }
                    invalidate();
                }
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }
}