public class CircleHorizontalBarChartRenderer extends HorizontalBarChartRenderer {

    public CircleHorizontalBarChartRenderer(BarDataProvider chart, ChartAnimator animator, ViewPortHandler viewPortHandler) {
        super(chart, animator, viewPortHandler);
    }

    @Override
    protected void drawDataSet(Canvas c, IBarDataSet dataSet, int index) {
        Transformer trans = mChart.getTransformer(dataSet.getAxisDependency());

        mShadowPaint.setColor(dataSet.getBarShadowColor());

        float phaseX = mAnimator.getPhaseX();
        float phaseY = mAnimator.getPhaseY();

        // initialize the buffer
        BarBuffer buffer = mBarBuffers[index];
        buffer.setPhases(phaseX, phaseY);
        buffer.setBarSpace(dataSet.getBarSpace());
        buffer.setDataSet(index);
        buffer.setInverted(mChart.isInverted(dataSet.getAxisDependency()));

        buffer.feed(dataSet);

        trans.pointValuesToPixel(buffer.buffer);

        int length = buffer.buffer.length;
        float left = 0;
        float right = 0;
        float top = buffer.buffer[length - 3];
        float bot = buffer.buffer[length - 1];
        boolean leftSaved = false;

        for (int j = 0; j < buffer.size(); j += 4) {

            if (!mViewPortHandler.isInBoundsTop(buffer.buffer[j + 3]))
                break;

            if (!mViewPortHandler.isInBoundsBottom(buffer.buffer[j + 1]))
                continue;

            // Set the color for the currently drawn value. 
            // If the index is
            // out of bounds, reuse colors.
            int color = dataSet.getColor(j / 4);
            mRenderPaint.setColor(color);
            if (color != 0 && !leftSaved) {
                leftSaved = true;
                left = buffer.buffer[j];
            }
            if (j > 4) { // it works but its ugly
                right = buffer.buffer[j - 2];
            }

            c.drawRect(buffer.buffer[j], buffer.buffer[j + 1] + 10, buffer.buffer[j + 2],
                    buffer.buffer[j + 3] - 10, mRenderPaint);
        }

        Paint erasePaint = new Paint();
        erasePaint.setAntiAlias(true);
        erasePaint.setStyle(Paint.Style.STROKE);
        int paintWidth = 20;
        erasePaint.setStrokeWidth(paintWidth);
        erasePaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        c.drawRoundRect(new RectF(left - paintWidth / 2, top, right + paintWidth / 2, bot), 30, 30, erasePaint);
    }

}