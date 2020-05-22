numberPicker.setMaxValue(10);
    numberPicker.setMinValue(0);
    numberPicker.setFormatter(new NumberPicker.Formatter() {
        @Override
        public String format(int i) {
            return String.format("%02d", i);
        }
    });