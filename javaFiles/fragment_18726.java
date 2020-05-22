@Override
    public void startEdit() {
        super.startEdit();

        if (textField == null) {
            createTextField();
        }

        textField.setText(getString());

        setText(null);
        setGraphic(textField);
        textField.selectAll();
    }