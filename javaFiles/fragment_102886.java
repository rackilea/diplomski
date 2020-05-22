// Create an XY Line chart
XYSeries series = new XYSeries("Random Data");
series.add(1.0, 500.2);
series.add(10.0, 694.1);
XYSeriesCollection data = new XYSeriesCollection(series);
JFreeChart chart = ChartFactory.createXYLineChart("XY Series Demo", "X", "Y", data,
                                                  PlotOrientation.VERTICAL, 
                                                  true, true, false);

// Create an NumberAxis
NumberAxis xAxis = new NumberAxis();
xAxis.setTickUnit(new NumberTickUnit(2));

// Assign it to the chart
XYPlot plot = (XYPlot) chart.getPlot();
plot.setDomainAxis(xAxis);