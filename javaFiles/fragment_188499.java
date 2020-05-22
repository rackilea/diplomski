@FXML
private void initialize() {
    sendButton.disableProperty().bind(textInput.textProperty().isEmpty());
}

@FXML
private void send() {
    String message = textInput.getText();
    if (message != null && !message.isEmpty()) {
        chatHistory.getItems().add("Sorin: " + message);
        textInput.clear();
    }
}