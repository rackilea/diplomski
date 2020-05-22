final TextField textfield = new TextField("SMS");
textfield.setValue("");
textfield.setMaxLength(160);

// Counter for input length
final Label counter = new Label();
counter.setValue(textfield.toString().length() + " / " + textfield.getMaxLength());

// Display the current length interactively in the counter
textfield.addValueChangeListener(new TextChangeListener() {
    public void textChange(TextChangeEvent event) {
        int len = event.getText().length();
        counter.setValue(len + " / " + textfield.getMaxLength());
    }
});

// Set how fast the listener is invoked (this is default)
textfield.setTextChangeEventMode(TextChangeEventMode.LAZY);