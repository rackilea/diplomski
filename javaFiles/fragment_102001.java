//remove current chart
mainPanel.removeAll(); //assuming you have nothing else in main panel other than a chart panel;
//add new chart
PriceVolumeChart chart = new PriceVolumeChart(file.getAbsolutePath());
mainPanel.add(chart);
mainPanel.validate();