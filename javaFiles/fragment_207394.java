DateAxis domainAxis = new DateAxis("Date");
    domainAxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);

    NumberAxis rangeAxis = new NumberAxis("Y");
    // Set a margin so that the label above the bar has a place to display
    rangeAxis.setUpperMargin(0.15);

    StackedXYBarRenderer renderer = new StackedXYBarRenderer(0.10);
    renderer.setDrawBarOutline(false);

    XYPlot plot = new XYPlot(dataset, domainAxis, rangeAxis, renderer);

    // Custom LabelGenerator, which displays the sum of the two series.
    XYItemLabelGenerator generator = new XYItemLabelGenerator() {
        @Override
        public String generateLabel(XYDataset dataset, int series, int item) {
            // Sum values for the two series of data
            double sum = dataset.getYValue(0, item) + dataset.getYValue(1, item);
            return "" + sum;
        }
    };

    // The LabelGenerator is linked to series 1 (top part of the bar)
    renderer.setSeriesItemLabelGenerator(1, generator);
    renderer.setSeriesItemLabelsVisible(1, true);
    renderer.setSeriesPositiveItemLabelPosition(1, new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12,
            TextAnchor.BASELINE_CENTER));
    renderer.setItemLabelAnchorOffset(10);

    JFreeChart chart = new JFreeChart("Stacked XY Bar Chart Demo 2", plot);
    return chart;