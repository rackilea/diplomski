private void createCustomLabels() {

    tChart1.addChartPaintListener(new ChartPaintAdapter() {

        @Override
        public void chartPainted(ChartDrawEvent e) {
            for (int i=0; i<tChart1.getAxes().getBottom().getMaximum(); i++) {
                addXCustomLabel(i, "Value " + i + " here");
            }
            tChart1.removeChartPaintListener(this);
            tChart1.refreshControl();
        }

    });

}