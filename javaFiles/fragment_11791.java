strokePaintBackground = new Paint(Paint.ANTI_ALIAS_FLAG);
strokePaintBackground.setStyle(Paint.Style.STROKE);
strokePaintBackground.setColor(Color.BLACK);
strokePaintBackground.setStrokeWidth(8);
strokePaintBackground.setPathEffect(new DashPathEffect(new float[]{30, 15}, 0));
strokePaintBackground.setStrokeCap(Paint.Cap.ROUND);
strokePaintBackground.setStrokeJoin(Paint.Join.ROUND);

strokePaintForground = new Paint(Paint.ANTI_ALIAS_FLAG);
strokePaintForground.setStyle(Paint.Style.STROKE);
strokePaintForground.setColor(Color.WHITE);
strokePaintForground.setStrokeWidth(6);
strokePaintForground.setPathEffect(new DashPathEffect(new float[]{30, 15}, 0));
strokePaintForground.setStrokeCap(Paint.Cap.ROUND);
strokePaintForground.setStrokeJoin(Paint.Join.ROUND);

canvas.drawPath(totalPath, strokePaintBackground);
canvas.drawPath(totalPath, strokePaintForground);