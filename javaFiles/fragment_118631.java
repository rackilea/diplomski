@FXML
private void initialize() {
    queueTable.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
        ...
    });
}