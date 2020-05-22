private void secondTimeSeries(final XYPlot plot) {
    final XYDataset secondDataset = this.createDataset(secondSeries);
    plot.setDataset(1, secondDataset); // the second dataset (datasets are zero-based numbering)
    plot.mapDatasetToDomainAxis(1, 0); // same axis, different dataset
    plot.mapDatasetToRangeAxis(1, 0); // same axis, different dataset

    final XYItemRenderer renderer = new XYLineAndShapeRenderer(true, false);
    renderer.setSeriesPaint(0, Color.BLUE);
    plot.setRenderer(1, renderer);
}

private void thirdTimeSeries(final XYPlot plot) {
    final XYDataset thirdDataset = this.createDataset(thirdSeries);
    plot.setDataset(2, thirdDataset); // the third dataset (datasets are zero-based numbering)
    plot.mapDatasetToDomainAxis(2, 0); // same axis, different dataset
    plot.mapDatasetToRangeAxis(2, 0); // same axis, different dataset

    final XYItemRenderer renderer = new XYLineAndShapeRenderer(true, false);
    renderer.setSeriesPaint(0, Color.GREEN);
    plot.setRenderer(2, renderer);
}