public void generateChart(List<FmsData> data, Valve valve) {

    HistogramDataset aggDs = createAggDataset(data);
    chart = createChart(aggDs, valve.getNumber());

    HistogramDataset valveDs = createValveDataset(data,valve.getNumber());
    XYPlot plot = chart.getXYPlot();

    // configure the second dataset
    plot.setDataset(0, aggDs);
    plot.setDataset(1, valveDs);
    plot.setRangeAxisLocation(0, AxisLocation.BOTTOM_OR_LEFT);
    plot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
    plot.mapDatasetToRangeAxis(0, 0);
    plot.mapDatasetToRangeAxis(1, 1);

    NumberAxis valveRangeAxis = new NumberAxis();
    plot.setRangeAxis(1, valveRangeAxis);

    XYBarRenderer renderer2 = new XYBarRenderer();
    plot.setRenderer(1, renderer2);
    plot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
    renderer2.setDrawBarOutline(false);
    // flat bars look best...
    renderer2.setBarPainter(new StandardXYBarPainter());
    renderer2.setShadowVisible(false);
    // end config second dataset