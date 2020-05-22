List<PaintCircle> circles = new ArrayList<PaintCircle>();

@Override
public boolean onTouchEvent(MotionEvent event) {
    // When touched

    switch (event.getAction()) {
    case MotionEvent.ACTION_DOWN:
        Paint blue = new Paint();
        blue.setColor(Color.BLUE);
        blue.setStyle(Style.FILL);
        circles.add(new PaintCircle(event.getX(),
                event.getY(), 20, blue));
     // ...

@Override
public void draw(Canvas c) {
    // Draw to the canvas
    super.draw(c);
    c.drawARGB(255, 255, 255, 255);
    for (PaintCircle circle : circles) {
        c.drawCircle(circle.cx, circle.cy, circle.radius,
                circle.paint);
    }
}