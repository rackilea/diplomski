...
// create axis
XDDFCategoryAxis categoryAxis = chart.createCategoryAxis(AxisPosition.BOTTOM);
categoryAxis.setTickLabelPosition(AxisTickLabelPosition.NONE);
XDDFValueAxis valueAxis = chart.createValueAxis(AxisPosition.LEFT);
valueAxis.setCrosses(AxisCrosses.AUTO_ZERO);
// Set AxisCrossBetween, so the left axis crosses the category axis between the categories.
// Else first and last category is exactly on cross points and the bars are only half visible.
valueAxis.setCrossBetween(AxisCrossBetween.BETWEEN);

// create chart data
XDDFBarChartData data = (XDDFBarChartData)chart.createData(ChartTypes.BAR, categoryAxis, valueAxis);
data.setBarDirection(BarDirection.BAR);
 ...