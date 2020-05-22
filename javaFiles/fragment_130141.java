horizontalBarChartMonthlySpending.getXAxis().setValueFormatter(new AxisValueFormatter() {
        @Override
        public String getFormattedValue(float value, AxisBase axis) {
            return entries.get((int) value).getData().toString();
        }

        @Override
        public int getDecimalDigits() {
            return 0;
        }
    });

    XAxis xAxis = horizontalBarChartMonthlySpending.getXAxis();
    xAxis.setGranularity(1f);
    xAxis.setGranularityEnabled(true);