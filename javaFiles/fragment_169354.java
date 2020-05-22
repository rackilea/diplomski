final JFormattedTextField textField1 = new JFormattedTextField(new Float(10.01));
    textField1.setFormatterFactory(new AbstractFormatterFactory() {

        @Override
        public AbstractFormatter getFormatter(JFormattedTextField tf) {
            NumberFormat format = DecimalFormat.getInstance();
            format.setMinimumFractionDigits(2);
            format.setMaximumFractionDigits(2);
            format.setRoundingMode(RoundingMode.HALF_UP);
            InternationalFormatter formatter = new InternationalFormatter(format);
            formatter.setAllowsInvalid(false);
            formatter.setMinimum(0.0);
            formatter.setMaximum(1000.00);
            return formatter;
        }
    });
}