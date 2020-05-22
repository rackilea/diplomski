JFreeChart chart = ChartFactory.createXYLineChart(...);
    DayOfYearAxis doyAxis = new DayOfYearAxis();
    /* optional
    doyAxis.setAutoRange(false);
    doyAxis.setRange(new Range(min_yday, max_yday));
    */
    chart.getXYPlot().setDomainAxis(doyAxis);