//create the series - add some dummy data
    XYSeries series1 = new XYSeries("series1");
    XYSeries series2 = new XYSeries("series2");
    series1.add(1000, 1000);
    series1.add(1150, 1150);
    series1.add(1250, 1250);

    series2.add(1000, 111250);
    series2.add(1150, 211250);
    series2.add(1250, 311250);

    //create the datasets
    XYSeriesCollection dataset1 = new XYSeriesCollection();
    XYSeriesCollection dataset2 = new XYSeriesCollection();
    dataset1.addSeries(series1);
    dataset2.addSeries(series2);

    //construct the plot
    XYPlot plot = new XYPlot();
    plot.setDataset(0, dataset1);
    plot.setDataset(1, dataset2);

    //customize the plot with renderers and axis
    plot.setRenderer(0, new XYSplineRenderer());//use default fill paint for first series
    XYSplineRenderer splinerenderer = new XYSplineRenderer();
    splinerenderer.setSeriesFillPaint(0, Color.BLUE);
    plot.setRenderer(1, splinerenderer);
    plot.setRangeAxis(0, new NumberAxis("Series 1"));
    plot.setRangeAxis(1, new NumberAxis("Series 2"));
    plot.setDomainAxis(new NumberAxis("X Axis"));

    //Map the data to the appropriate axis
    plot.mapDatasetToRangeAxis(0, 0);
    plot.mapDatasetToRangeAxis(1, 1);   

    //generate the chart
    JFreeChart chart = new JFreeChart("MyPlot", getFont(), plot, true);
    chart.setBackgroundPaint(Color.WHITE);
    JPanel chartPanel = new ChartPanel(chart);