plotArea.addListener(SWT.MouseHover, new Listener() {

        @Override
        public void handleEvent(final Event event) {
            IAxis xAxis = chart.getAxisSet().getXAxis(0);
            IAxis yAxis = chart.getAxisSet().getYAxis(0);

            int x = (int) Math.round(xAxis.getDataCoordinate(event.y));
            double y = yAxis.getDataCoordinate(event.x);

            ISeries[] series = chart.getSeriesSet().getSeries();

            double currentY = 0.0;
            ISeries currentSeries = null;

            /* over all series */
            for (ISeries serie : series) {
                double[] yS = serie.getYSeries();

                if (x < yS.length && x >= 0) {
                    currentY += yS[x];
                    currentSeries = serie;

                    if (currentY > y) {
                        y = yS[x];
                        break;
                    }
                }
            }

            if (currentY >= y) {
                plotArea.setToolTipText(currentSeries.getDescription() + ": " + Math.round(y) + " ms");
            } else {
                plotArea.setToolTipText(null);
            }
        }
});