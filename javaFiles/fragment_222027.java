@FXML
private ChoiceBox<...> categoryDrop ;

public void initialize() {
    categoryDrop.setOnAction(this::folderByCategory);
    // existing code ...
}

@FXML
private void folderByCategory(ActionEvent event) {
    // existing code...
}