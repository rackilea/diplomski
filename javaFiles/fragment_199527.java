public Point2D getPointOnEdge(float angel, Rectangle bounds) {

    float radius = Math.max(bounds.width, bounds.height) / 2;

    float x = radius;
    float y = radius;

    double rads = Math.toRadians((angel + 90));

    // Calculate the outter point of the line
    float xPosy = (float) (x + Math.cos(rads) * radius);
    float yPosy = (float) (y + Math.sin(rads) * radius);

    return new Point2D.Float(xPosy + bounds.x, yPosy + bounds.y);

}