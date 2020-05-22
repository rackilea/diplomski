final long MILLION = 1000000L;
    final long BILLION = 1000000000L;
    final long TRILLION = 1000000000000L;
    final long THOUSAND = 1000L;

    NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
    rangeAxis.setNumberFormatOverride(new NumberFormat() {

        @Override
        public Number parse(String source, ParsePosition parsePosition) {
            return null;
        }

        @Override
        public StringBuffer format(long number, StringBuffer toAppendTo, FieldPosition pos) {

            String temp =  number < THOUSAND ? String.valueOf(number) :
                number < MILLION ?  (int)(number / THOUSAND) + " K" :
                number < BILLION ?  (int)(number / MILLION) + " M" :
                number < TRILLION ? (int)(number / BILLION) + " B" : 
                (int)(number / TRILLION) + " T";
            return new StringBuffer(temp);
        }

        @Override
        public StringBuffer format(double number, StringBuffer toAppendTo, FieldPosition pos) {

            String temp =  number < THOUSAND ? String.valueOf(number) :
                number < MILLION ?  (int)(number / THOUSAND) + " K" :
                number < BILLION ?  (int)(number / MILLION) + " M" :
                number < TRILLION ? (int)(number / BILLION) + " B" : 
                (int)(number / TRILLION) + " T";
            return new StringBuffer(temp);
        }
    });