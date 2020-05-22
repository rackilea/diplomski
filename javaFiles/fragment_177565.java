IntegerBinding ib = Bindings.length(textField.textProperty());

ib.addListener((ObservableValue<? extends Number> observable, Number oldValue, Number newValue) -> {
    if(newValue.intValue() >= 3) {
        // trigger auto complete
    }
});