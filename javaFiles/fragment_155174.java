@FXML
private ListView<ChatMessage> chatHistory;

private String user = "Sorin";
private static final PseudoClass USER_MESSAGE = PseudoClass.getPseudoClass("user-message");

@FXML
private void initialize() {
    sendButton.disableProperty().bind(textInput.textProperty().isEmpty());

    final ColumnConstraints ownUserConstraints = new ColumnConstraints();
    ownUserConstraints.setHalignment(HPos.LEFT);
    ownUserConstraints.setHgrow(Priority.ALWAYS);

    final ColumnConstraints foreignUserConstraints = new ColumnConstraints();
    foreignUserConstraints.setHalignment(HPos.RIGHT);
    foreignUserConstraints.setHgrow(Priority.ALWAYS);

    final ColumnConstraints userConstraints = new ColumnConstraints();
    userConstraints.setHgrow(Priority.NEVER);

    chatHistory.setCellFactory(lv -> new ListCell<ChatMessage>() {

        private final Label message;
        private final Label userName;
        private final GridPane content;

        {
            message = new Label();
            userName = new Label();
            content = new GridPane();
            content.setHgap(10);
            content.addRow(0, userName, message);
            content.getColumnConstraints().addAll(userConstraints, userConstraints);
        }

        @Override
        protected void updateItem(ChatMessage item, boolean empty) {
            super.updateItem(item, empty);

            boolean userMessage;
            if (empty || item == null) {
                userMessage = false;
                setGraphic(null);
            } else {
                userMessage = user.equals(item.getUserName());
                userName.setText(item.getUserName() + ":");
                message.setText(item.getMessage());
                setGraphic(content);

                content.getColumnConstraints().set(1, userMessage
                        ? ownUserConstraints
                        : foreignUserConstraints);
            }
            pseudoClassStateChanged(USER_MESSAGE, userMessage);
        }

    });
}