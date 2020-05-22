@FXML
private void handleCommand() {
    if(handlePasswordField()) {
        doAllTheOtherStuff();
    }
    Platform.exit();
}