allStudentsList.getSelectionModel().selectedItemProperty().addListener((obs, oldValue, newValue) -> {
    if (newValue != null) {

        Platform.runLater(() -> {
            allStudentsList.getSelectionModel().select(-1);
            currentStudentList.getItems().add(newValue);
            allStudentsList.getItems().remove(newValue);
        });
    }
});