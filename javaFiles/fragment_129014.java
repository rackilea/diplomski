ind dpRadius = 1;
Resources r = getResources();
float pxRadius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpRadius, r.getDisplayMetrics());

Paint paint = new Paint();
paint.setColor(Color.BLUE);
paint.setStrokeWidth(pxRadius);
paint.setStyle(Paint.Style.STROKE);

// your drawPoints code ...