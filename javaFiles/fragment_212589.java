private XYSeriesCollection collection = new XYSeriesCollection();
private XYSeries series = new XYSeries("Result");
...
collection.addSeries(series);
JFreeChart chart = ChartFactory.createXYLineChart(
    "Newton's Method", "X", "Y", collection,
    PlotOrientation.VERTICAL, false, true, false);
XYPlot plot = (XYPlot) chart.getPlot();
plot.getRangeAxis().setRange(1.4, 1.51);
plot.getDomainAxis().setStandardTickUnits(
    NumberAxis.createIntegerTickUnits());
XYLineAndShapeRenderer renderer =
    (XYLineAndShapeRenderer) plot.getRenderer();
renderer.setSeriesShapesVisible(0, true);
this.add(new ChartPanel(chart), BorderLayout.CENTER);
...
private int n;
@Override
protected void process(List<Double> chunks) {
    for (double d : chunks) {
        label.setText(df.format(d));
        series.add(++n, d);
    }
}