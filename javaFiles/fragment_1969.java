textField.setOnKeyPressed(e -> {
    if (e.getCode() == KeyCode.ESCAPE) {
        Button cancelButton = (Button)
            dialog.getDialogPane().lookupButton(ButtonType.CANCEL);
        cancelButton.fire();
    }
});