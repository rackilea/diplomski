JFXPanelScatterChartNS<Number, String> chart = 
    JFXPanelScatterChartNS.createNumberStringInstance(new String[] {"A", "B", "C"});
chart.addSeries("Series1", "Series 1", 1, "A");

JFXPanelScatterChartNS<Number, Number> numberChart = 
    JFXPanelScatterChartNS.createNumberInstance();
numberChart.addSeries("Series2", "Series 2", 5, 3);