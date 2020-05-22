TextArea textArea = new TextArea();
UnaryOperator<Change> filter = c -> {
    c.setText(c.getText().replaceAll("\r", "\n"));
    return c ;
};
textField.setTextFormatter(new TextFormatter<>(filter));