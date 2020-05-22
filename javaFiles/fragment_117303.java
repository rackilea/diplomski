class LogXYSeries extends SimpleXYSeries {

        public LogXYSeries(String title) {
            super(title);
        }

        @Override
        public Number getY(int index) {
            final Number rawY = super.getY(index);
            if(rawY != null) {
                Math.log10(rawY.doubleValue());
            }
            return null;
        }
}