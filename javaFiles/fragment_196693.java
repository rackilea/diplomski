private XYSeriesCollection dataset;
private XYSeries series;
...
dataset.removeSeries(series);
series.setKey("Stochastic Data");
dataset.addSeries(series);