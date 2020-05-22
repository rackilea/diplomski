private static class DottedUnderlineSpan extends ReplacementSpan {
private Paint p;
private int mWidth;
private String mSpan;

private float mSpanLength;
private boolean mLengthIsCached = false;

public DottedUnderlineSpan(int _color, String _spannedText){
    p = new Paint();
    p.setColor(_color);
    p.setStyle(Paint.Style.STROKE);
    p.setPathEffect(new DashPathEffect(new float[]{mDashPathEffect, mDashPathEffect}, 0));
    p.setStrokeWidth(mStrokeWidth);
    mSpan = _spannedText;
}

@Override
public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
    mWidth = (int) paint.measureText(text, start, end);
    return mWidth;
}

@Override
public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
    canvas.drawText(text, start, end, x, y, paint);
    if(!mLengthIsCached)
        mSpanLength = paint.measureText(mSpan);

    // https://code.google.com/p/android/issues/detail?id=29944
    // canvas.drawLine can't draw dashes when hardware acceleration is enabled,
    // but canvas.drawPath can
    Path path = new Path();
    path.moveTo(x, y + mOffsetY);
    path.lineTo(x + mSpanLength, y + mOffsetY);
    canvas.drawPath(path, this.p);
}
}