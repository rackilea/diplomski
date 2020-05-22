model.reLoadData();
final int currentEmail = emailForClient; // I'm assuming emailForClient is an int

Platform.runLater(() -> {
    listView.setItems(model.getEmailList());

    if (currentOnServer > currentEmail) {
        new Alert(Alert.AlertType.INFORMATION, "Hai recevuto un email!").showAndWait();
    }
});

emailForClient = currentOnServer;