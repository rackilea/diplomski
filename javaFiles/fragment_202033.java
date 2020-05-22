plotArea.addListener(SWT.Paint, new Listener() {

        /**
         * The x-axis offset
         */
        private int xAxisOffset = 8;

        /**
         * The y-axis offset.
         */
        private int yAxisOffset = 3;

        @Override
        public void handleEvent(final Event event) {
            GC gc = event.gc;

            ISeries[] series = chart.getSeriesSet().getSeries();

            for (double xAxis : series[0].getXSeries()) {

                double techTime = series[0].getYSeries()[(int) xAxis];
                double thinkTime = series[1].getYSeries()[(int) xAxis];

                int totalTime = (int) Math.round(techTime + thinkTime);
                int xCoord = chart.getAxisSet().getXAxis(0).getPixelCoordinate(xAxis) - this.xAxisOffset;
                int yCoord = chart.getAxisSet().getYAxis(0).getPixelCoordinate(totalTime / this.yAxisOffset);

                gc.drawText(totalTime + " ms", yCoord, xCoord, SWT.DRAW_TRANSPARENT);
            }
        }
});