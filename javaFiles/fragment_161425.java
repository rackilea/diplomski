XYPlot xyPlot = chart.getXYPlot();
XYDataset dataset = (XYDataset)xyPlot.getDataset();
double lowerBound = dataset.getXValue(0, 0);
double lowerBound = getDomainLowerBound(false);
java.util.Date lowerDate = new java.util.Date((long)lowerBound);
domainAxis.setMinimumDate(lowerDate);