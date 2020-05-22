final JFreeChart result = ChartFactory.createTimeSeriesChart(
    TITLE, "hh:mm:ss", " ", createDatasetTemp(), true, true, false);
…
plot.setDataset(1, createDatasetAir());
plot.setDataset(2, createDatasetInso());
plot.setRangeAxis(0, temp);
plot.setRangeAxisLocation(0, AxisLocation.BOTTOM_OR_LEFT);
plot.setRangeAxis(1, air);
plot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_LEFT);
plot.setRangeAxis(2, inso);
plot.setRangeAxisLocation(2, AxisLocation.BOTTOM_OR_LEFT);
plot.mapDatasetToRangeAxis(0, 0);
plot.mapDatasetToRangeAxis(1, 1);
plot.mapDatasetToRangeAxis(2, 2);