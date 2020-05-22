public Rectangle2D getActiveBounds(float angel, Rectangle bounds) {

    Point2D p = getPointOnEdge(angel, bounds);

    return new Rectangle2D.Double(p.getX() - 4, p.getY() - 4, 8, 8);

}