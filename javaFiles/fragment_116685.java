public static Point converPointTo2D(Point point, Rectangle2D dataArea, XYPlot plot){
    double x;
    double y;

    CustomNumberAxis xAxis = (CustomNumberAxis) plot.getDomainAxis();
    CustomNumberAxis yAxis = (CustomNumberAxis) plot.getRangeAxis();

    x = xAxis.java2DToValue(point.getX(), dataArea, 
            RectangleEdge.BOTTOM);
    y = yAxis.java2DToValue(point.getY(), dataArea, 
            RectangleEdge.RIGHT);

    return new Point(x, y);
}