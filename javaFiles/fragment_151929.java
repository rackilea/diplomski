public static <T> void fixSpinner2(Spinner<T> aSpinner) {
    aSpinner.getEditor().setOnAction(action -> {
        String text = aSpinner.getEditor().getText();
        SpinnerValueFactory<T> factory = aSpinner.getValueFactory();
        if (factory != null) {
            StringConverter<T> converter = factory.getConverter();
            if (converter != null) {
                T value = converter.fromString(text);
                if (null != value) {
                    factory.setValue(value);
                }
                else {
                    aSpinner.getEditor().setText(converter.toString(factory.getValue()));
                }
            }
        }
        action.consume();
    });
}