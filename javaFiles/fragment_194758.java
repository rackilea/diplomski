private static boolean isCollision(Point2D.Double p1, double r1, Point2D.Double p2, double r2)
{
    final double a = r1 + r2;
    final double dx = p1.x - p2.x;
    final double dy = p1.y - p2.y;
    return a * a > (dx * dx + dy * dy);
}