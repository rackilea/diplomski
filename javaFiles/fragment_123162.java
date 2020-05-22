import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;


public class LayerRectangle extends View {


    private int measuredWidth, measuredHeight;
    private Paint mBackgroundPaint, mYellowLinePaint, mWhiteLinePaint;
    private RectF mBackgroundRect, mYellowLineRectF, mWhiteLineRectF;


    public LayerRectangle(Context context) {
        super(context);
        init(context, null, 0);
    }

    public LayerRectangle(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public LayerRectangle(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs, defStyleAttr);
    }

    private void init(Context context, AttributeSet attributeSet, int defStyle) {

        mBackgroundPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mBackgroundPaint.setColor(0xFF3C3C3C);
        mBackgroundPaint.setStyle(Paint.Style.FILL);

        mYellowLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mYellowLinePaint.setColor(0xFFFFFF00);
        mYellowLinePaint.setStyle(Paint.Style.FILL);

        mWhiteLinePaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mWhiteLinePaint.setColor(0xFFFFFFFF);
        mWhiteLinePaint.setStyle(Paint.Style.FILL);
    }


    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measuredHeight = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        measuredWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);

        mBackgroundRect = new RectF(0, 0, measuredWidth, measuredHeight);
        mYellowLineRectF = new RectF(0, 0.7f * measuredHeight, measuredWidth, 0.8f * measuredHeight);
        mWhiteLineRectF = new RectF(0, 0.9f * measuredHeight, measuredWidth, measuredHeight);

        setMeasuredDimension(measuredWidth, measuredHeight);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        if (measuredHeight == 0 || measuredWidth == 0)
            return;

        canvas.drawRect(mBackgroundRect, mBackgroundPaint);
        canvas.drawRect(mYellowLineRectF, mYellowLinePaint);
        canvas.drawRect(mWhiteLineRectF, mWhiteLinePaint);
    }
}