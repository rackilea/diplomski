public Spinner() {
    getStyleClass().add(DEFAULT_STYLE_CLASS);
    setAccessibleRole(AccessibleRole.SPINNER);

    getEditor().setOnAction(action -> {
        String text = getEditor().getText();
        SpinnerValueFactory<T> valueFactory = getValueFactory();
        if (valueFactory != null) {
            StringConverter<T> converter = valueFactory.getConverter();
            if (converter != null) {
                T value = converter.fromString(text);
                valueFactory.setValue(value);
            }
        }
    });