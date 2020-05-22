public class Diagram extends View {
    private final RectF mBackgroundRect = new RectF();
    private final RectF mYellowLineRectF = new RectF();
    private final RectF mWhiteLineRectF = new RectF();

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measuredHeight = getDefaultSize(getSuggestedMinimumHeight(), heightMeasureSpec);
        measuredWidth = getDefaultSize(getSuggestedMinimumWidth(), widthMeasureSpec);

        mBackgroundRect.set(0, 0, measuredWidth, measuredHeight);
        mYellowLineRectF.set(0, 0.2f * measuredHeight, measuredWidth, 0.3f * measuredHeight);
        mWhiteLineRectF.set(0, 0.0f * measuredHeight, measuredWidth, 0.1f * measuredHeight);

        setMeasuredDimension(measuredWidth, measuredHeight);
    }
}