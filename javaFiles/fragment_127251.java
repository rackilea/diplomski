JFrame frame = new JFrame("Many charts same frame");
frame.setLayout( new FlowLayout() );

JFreeChart barChart1 = 
    ChartFactory.createHistogram("Histogram1","", "", dataset,
            PlotOrientation.VERTICAL, true, true, false);

frame.getContentPane().add(new ChartPanel(barChart1));

JFreeChart barChart2 = 
    ChartFactory.createHistogram("Histogram2","", "", dataset,
            PlotOrientation.VERTICAL, true, true, false);

frame.getContentPane().add(new ChartPanel(barChart2));

frame.pack();

frame.setVisible(true);