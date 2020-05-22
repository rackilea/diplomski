PieDataset dataset = createDataset();

JFreeChart chart = createChart(dataset, chartTitle);

ChartPanel chartPanel = new ChartPanel(chart);

chartPanel.setPreferredSize(new java.awt.Dimension(500, 270));

yourPanel.add(chartPanel);     // this line is new