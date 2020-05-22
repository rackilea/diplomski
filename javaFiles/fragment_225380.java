private class MyPoint {

        private float x;
        private float y;
        private int color;
        private int size;
    // + constructor, getters and setters
}

@Override
    public void onDraw(Canvas canvas) {
        for (MyPoint point : points) {
            paint.setColor(point.get_color());
            canvas.drawCircle(point.x, point.y, current_size, paint);
        }
    }