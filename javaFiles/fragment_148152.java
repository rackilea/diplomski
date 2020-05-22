class Point
{
    int x;
    int y;
}


List<Point> points = new List<Point>();

onMove(int newX, int newY)
{
    Point p = new Point();
    p.x = newX;
    p.y = newY;

    points.add(p);
}


onDraw()
{
    for(Point p : points)
    {
        canvas.drawPoint(p.x, p.y, paint);
    }
}