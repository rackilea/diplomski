TextField purchaseCostField = new TextField("$");
UnaryOperator<TextFormatter.Change> filter = change -> {
    if (change.getControlNewText().startsWith("$")) {
        return change ;
    } else {
        return null ;
    }
};
TextFormatter<String> formatter = new TextFormatter<>(filter);
purchaseCostField.setTextFormatter(formatter);