CategoryPlot plot = (CategoryPlot) chart.getPlot();       
CategoryItemRenderer renderer = plot.getRenderer(); 
renderer.setSeriesPaint(0, Color.blue); 

NumberAxis xAxis = new NumberAxis();
DecimalFormat format = (DecimalFormat)DecimalFormat.getNumberInstance(Locale.ENGLISH);
format.applyPattern("#");
xAxis.setNumberFormatOverride(format);

xAxis.setLabel("Cycles");
plot.setRangeAxis(xAxis);

renderer.setBaseToolTipGenerator(new IntervalCategoryToolTipGenerator("{3} - {4}", format));