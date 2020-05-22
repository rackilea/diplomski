List<Date> wtArray = new ArrayList<Date>();
double[] weight = new double[] { 70, 71, 74, 73, 70, 71, 75, 76, 75, 73, 75, 73 };
for (int i = 0; i < 12; i++) {
  wtArray.add(new Date(108, i, 1));
}
TimeSeries diaSeries = new TimeSeries("Weight");

for (int i = 0; i < wtArray.size(); i++) {
  diaSeries.add(wtArray.get(i), weight[i]);
}

XYMultipleSeriesDataset dataset = new XYMultipleSeriesDataset();
dataset.addSeries(diaSeries);

XYMultipleSeriesRenderer mrenderer = new XYMultipleSeriesRenderer();

XYSeriesRenderer renderer = new XYSeriesRenderer();
renderer.setColor(Color.RED);
renderer.setPointStyle(PointStyle.DIAMOND);
renderer.setFillPoints(true);
mrenderer.addSeriesRenderer(renderer);

return ChartFactory.getTimeChartIntent(context, dataset, mrenderer, "MM/dd/yyyy");