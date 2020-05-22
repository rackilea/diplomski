Series barSeries = new HorizBar(tChart1.getChart());
barSeries.fillSampleValues();

barSeries.addSeriesMouseListener(new SeriesMouseAdapter() {

    @Override
    public void seriesClicked(SeriesMouseEvent arg0) {
        // show info here for the arg0.getValueIndex()
    }
});