public boolean isPointInPolygon(Point p, Point[] points)
    {

        Polygon polygon = new Polygon();//java.awt.Polygon

        for(Point point : points) {

            polygon.addPoint(point.x, point.y);
        }

        return polygon.contains(p);
    }