mPaint = new Paint();
mPaint.setAntiAlias(true);
mPaint.setStrokeWidth(5);
mPaint.setStrokeCap(Paint.Cap.ROUND);
mPaint.setTextSize(64);
mPaint.setTypeface(Typeface.create(Typeface.SERIF, Typeface.ITALIC));
// ...
float w = mPaint.measureText(text, 0, text.length());