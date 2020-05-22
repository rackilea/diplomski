public class MyYAxisValueFormatter implements IValueFormatter {

        private DecimalFormat mFormat;

        public MyYAxisValueFormatter() {
        // format values to 1 decimal digit
            mFormat = new DecimalFormat("###,###,##0.0");
        }

        @Override
        public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
            // "value" represents the position of the label on the axis (x or y)
             if(value > 0) {
               return mFormat.format(value);
             } else {
               return "";
             }
        }
    }