Paint myPaint = new Paint();
    myPaint.setColor(Color.rgb(0, 0, 0));
    myPaint.setStrokeWidth(10);
    canvas.drawCircle(50, 100, 50, myPaint);

    Paint p = new Paint();
    p.setColor(Color.rgb(250, 250, 250));
    p.setStrokeWidth(2);

    float angle = 45;
    canvas.save();
    canvas.rotate(angle, 50, 100);

    canvas.drawLine(50,100,50,60,p);

    canvas.restore();