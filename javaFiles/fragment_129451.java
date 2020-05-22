private void firstTimeSeries(final XYPlot plot) {
    final ValueAxis xaxis = plot.getDomainAxis();
    xaxis.setAutoRange(true);

    // Domain axis would show data of 60 seconds for a time
    xaxis.setFixedAutoRange(60000.0); // 60 seconds
    xaxis.setVerticalTickLabels(true);

    final ValueAxis yaxis = plot.getRangeAxis();
    yaxis.setRange(0.0, 300.0);

    final XYItemRenderer renderer = plot.getRenderer();
    renderer.setSeriesPaint(0, Color.RED);

    final NumberAxis yAxis1 = (NumberAxis) plot.getRangeAxis();
    yAxis1.setTickLabelPaint(Color.RED);
}