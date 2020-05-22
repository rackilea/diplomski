private void commitEditorText() {
    if (!isEditable()) return;
    String text = getEditor().getText();
    SpinnerValueFactory<T> valueFactory = getValueFactory();
    if (valueFactory != null) {
        StringConverter<T> converter = valueFactory.getConverter();
        if (converter != null) {
            T value = converter.fromString(text);
            valueFactory.setValue(value);
        }
    }
}