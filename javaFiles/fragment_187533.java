np.setMaxValue(10);
 np.setMinValue(1);

 np.setFormatter(new NumberPicker.Formatter() {
        @Override
        public String format(int i) {
            return String.valueOf(i*10);
        }
 });