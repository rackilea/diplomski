AffineTransform atg;

Point2D calcCoordinates(MouseEvent e)
{
    Point p = new Point(e.getX(), e.getY());
    try
    {
        return atg.inverseTransform(p, null);
    }
    catch (NoninvertibleTransformException ex)
    {
        ex.printStackTrace();
        return p;
    }
}