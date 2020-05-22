Pattern allowedCharactersPattern = Pattern.compile("[0-9+]*");

DocumentFilter filter = new DocumentFilter() {
    @Override
    public void insertString(FilterBypass bypass,
                             int position,
                             String newText,
                             AttributeSet attr)
    throws BadLocationException {
        if (allowedCharactersPattern.matcher(newText).matches()) {
            super.insertString(bypass, position, newText, attr);
        }
    }

    @Override
    public void replace(FilterBypass bypass,
                        int position,
                        int length,
                        String newText,
                        AttributeSet attr)
    throws BadLocationException {
        if (allowedCharactersPattern.matcher(newText).matches()) {
            super.replace(bypass, position, length, newText, attr);
        }
    }
};

String regex = "^(\\+93|0)?7[0-9]{8}$";
Pattern pattern = Pattern.compile(regex);

JFormattedTextField.AbstractFormatter formatter =
    new JFormattedTextField.AbstractFormatter() {
        private static final long serialVersionUID = 1;

        @Override
        protected DocumentFilter getDocumentFilter() {
            return filter;
        }

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