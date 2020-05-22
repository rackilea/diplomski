String regex = "^(\\+93|0)?7[0-9]{8}$";
Pattern pattern = Pattern.compile(regex);

JFormattedTextField.AbstractFormatter formatter =
    new JFormattedTextField.AbstractFormatter() {
        private static final long serialVersionUID = 1;

        @Override
        public Object stringToValue(String text)
        throws ParseException {
            if (text != null && !pattern.matcher(text).matches()) {
                throw new ParseException(text, 0);
            }
            return text;
        }

        @Override
        public String valueToString(Object value) {
            return Objects.toString(value, null);
        }
    };

JTextField txtphone = new JFormattedTextField(formatter);