mChart.getXAxis().setValueFormatter(new IAxisValueFormatter() {
        private SimpleDateFormat mFormat = new SimpleDateFormat("dd MMM HH:mm");

        @Override
        public String getFormattedValue(float value, AxisBase axis) {

            long millis = (long) value;
            return mFormat.format(new Date(millis));
        }
    });
chart.getXAxis().setValueFormatter(axisValueFormatter);
chart.setGranularity(1.0f);
chart.setGranularityEnabled(true);