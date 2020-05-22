JFreeChart chart = // create your XY chart here.
XYPlot plot = chart.getXYPlot();
OHLCSeriesCollection ohlsSeriesDataset = // create you ohlc dataset here.
TimeSeriesCollection timeSeriesDataset = // create you time dataset here.
AbstractXYItemRenderer olhsSeriesRenderer = // create your ohlc renderer here.
AbstractXYItemRenderer timeSeriesRenderer = // create your time renderer here.

plot.setDataset(0, ohlsSeriesDataset);
plot.setDataset(1, timeSeriesDataset);
plot.setRenderer(0, olhsSeriesRenderer);
plot.setRenderer(1, timeSeriesRenderer);