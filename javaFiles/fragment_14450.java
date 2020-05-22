@FXML
private void initialize() {
    taskManagerView.getSelectionModel().selectedItemProperty().addListener((o, oldValue, newValue) -> {
        if (newValue == null) {
            textArea.setText("");
            // TODO: clear other controls
        } else {
            textArea.setText(newValue.getTask());
            // TODO: set values to other controls
        }
    });
}