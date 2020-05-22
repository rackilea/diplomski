public XYMultipleSeriesRenderer getBarDemoRenderer() {
    XYMultipleSeriesRenderer renderer = new XYMultipleSeriesRenderer();
    renderer.setAxisTitleTextSize(16);
    renderer.setChartTitleTextSize(20);
    renderer.setLabelsTextSize(15);
    renderer.setLegendTextSize(15);
    renderer.setMargins(new int[] {20, 30, 15, 0});
    SimpleSeriesRenderer r = new SimpleSeriesRenderer();
    r.setColor(Color.BLUE);
    renderer.addSeriesRenderer(r);
    r = new SimpleSeriesRenderer();
    r.setColor(Color.GREEN);
    renderer.addSeriesRenderer(r);
    return renderer;
  }

 private XYMultipleSeriesDataset getBarDemoDataset() {
    XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
    final int nr = 10;
    Random r = new Random();
    for (int i = 0; i < SERIES_NR; i++) {
      CategorySeries series = new CategorySeries("Demo series " + (i + 1));
      for (int k = 0; k < nr; k++) {
        series.add(100 + r.nextInt() % 100);
      }
      dataset.addSeries(series.toXYSeries());
    }
    return dataset;
  }



private void setChartSettings(XYMultipleSeriesRenderer renderer) {
    renderer.setChartTitle("Chart demo");
    renderer.setXTitle("x values");
    renderer.setYTitle("y values");
    renderer.setXAxisMin(0);
    renderer.setXAxisMax(5);
    renderer.setYAxisMin(0);
    renderer.setYAxisMax(250);
  }