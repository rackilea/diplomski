public SeriesAndPointDragAndMove(String paramString) {
    …
    series.addChangeListener(new SeriesChangeListener() {
        @Override
        public void seriesChanged(SeriesChangeEvent e) {
            XYSeries series = (XYSeries) e.getSource();
            System.out.println(series.getItems());
        }
    });
}