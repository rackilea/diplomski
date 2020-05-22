while(iter.hasNext()) {
    Point2D.Double polygon = iter.next();
    x = polygon.getX();
    y = polygon.getY();
    pen.move(x, y);
}