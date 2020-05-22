final XYPlot plot = getChart().getXYPlot();
  final ValueAxis domainAxis = plot.getDomainAxis();
  final ValueAxis rangeAxis = plot.getRangeAxis();
  final Rectangle2D plotRectangle = SWTUtils.toAwtRectangle(getScreenDataArea());
  final double chartX = domainAxis.java2DToValue(relativeX, plotRectangle, plot.getDomainAxisEdge());
  final double chartY = rangeAxis.java2DToValue(relativeY, plotRectangle, plot.getRangeAxisEdge());