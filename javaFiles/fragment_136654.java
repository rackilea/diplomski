textNode.textProperty().bind(new StringBinding() {
    { bind(textField.textProperty()); }
    @Override protected String computeValue() {
        return maskText(textField.textProperty().getValueSafe());
    }
});