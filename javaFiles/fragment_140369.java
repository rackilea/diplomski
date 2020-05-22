List<Point> points = ...

protected void doDraw(Canvas canvas) {
   Paint p = new Paint();
   p.setStyle(Paint.Style.FILL);
   p.setColor(Color.WHITE);

   for (Point p : points) {
      canvas.drawPoint(p.x, p.y, p);
   }
}

public boolean onTouchEvent(MotionEvent event) {   
   float x = event.getX();
   float y = event.getY();

   points.add(new Point(x, y));

   return true;
}