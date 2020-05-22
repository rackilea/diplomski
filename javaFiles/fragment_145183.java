barChart.getBarData().setValueFormatter(new IValueFormatter() {
        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            return entry.getData().toString();
        }
    });