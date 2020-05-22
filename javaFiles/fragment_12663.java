private static XYDataset createDataset() {
    XYSeriesCollection result = new XYSeriesCollection();
    XYSeries series = new XYSeries("Test");
    series.add(0, 2);
    // more points here
    series.add(10, 10);
    result.addSeries(series);
    return result;
}