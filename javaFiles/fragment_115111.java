public void drawPoints(Bitmap bitmap, List<Point> points) {
    // a canvas for drawing on the bitmap
    Canvas canvas = new Canvas(bitmap);
    // a paint to describe how points are drawn
    Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    paint.setColor(Color.RED);
    float radius = 4f;

    // draw points
    for(Point point : points) {
        canvas.drawCircle(point.x, point.y, radius, paint);
    }
    // the bitmap has now been updated
}