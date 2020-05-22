private JFreeChart createChart() {
    final XYDataset dataset = this.createDataset(series);
    final JFreeChart result = ChartFactory.createTimeSeriesChart("Dynamic Line And TimeSeries Chart", "Time", "Value", dataset, true, true, false);

    final XYPlot plot = result.getXYPlot();
    plot.setBackgroundPaint(new Color(0xffffe0));
    plot.setDomainGridlinesVisible(true);
    plot.setDomainGridlinePaint(Color.LIGHT_GRAY);
    plot.setRangeGridlinesVisible(true);
    plot.setRangeGridlinePaint(Color.LIGHT_GRAY);

    // first time series
    this.firstTimeSeries(plot);

    // second time series
    this.secondTimeSeries(plot);

    // third time series
    this.thirdTimeSeries(plot);

    return result;
}