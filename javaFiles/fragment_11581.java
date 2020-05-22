private boolean handlePasswordField() {
    if (!password.getText().isEmpty()) {
        this.rootPassword = password.getText();
        return true;
    } else {
        Alert alert = new Alert(AlertType.WARNING);
        alert.initOwner(nbtcInstaller.getPrimaryStage());
        alert.setTitle("No password");
        alert.setHeaderText("No password provided");
        alert.setContentText("Please enter a new ROOT password");
        alert.showAndWait();
        return false;
    }
}