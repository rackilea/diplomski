XYItemRenderer renderer = xyPlot.getRenderer();
    renderer.setSeriesPaint(0, Color.blue);
    double size = 20.0;
    double delta = size / 2.0;
    Shape shape1 = new Rectangle2D.Double(-delta, -delta, size, size);
    Shape shape2 = new Ellipse2D.Double(-delta, -delta, size, size);
    renderer.setSeriesShape(0, shape1);
    renderer.setSeriesShape(1, shape2);