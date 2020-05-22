private static XYDataset createDataset() {
  XYSeries dataset = new XYSeries("A",false,true);
  dataset.add(1,1);
  dataset.add(2,3);
  dataset.add(3,5);
  dataset.add(4,7);
  dataset.add(2.5,1);
  XYSeriesCollection ds = new XYSeriesCollection();
  ds.addSeries(dataset);
  return ds;
}