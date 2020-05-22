private Ellipse2D getEllipseFromCenter(double x, double y, double width, double height)
{
    double newX = x - width / 2.0;
    double newY = y - height / 2.0;

    Ellipse2D ellipse = new Ellipse2D.Double(newX, newY, width, height);

    return ellipse;
}