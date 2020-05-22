XYSeriesCollection dataset = createDataset();
JFreeChart chart = createChart(dataset);
Color color = new Color(0, 0, 255, 63);
double max = dataset.getSeries(0).getMaxX() * 1.1;
XYBoxAnnotation annotation = new XYBoxAnnotation(
    42, -1, max, 1, new BasicStroke(1f), color, color);
chart.getXYPlot().getRenderer().addAnnotation(annotation);