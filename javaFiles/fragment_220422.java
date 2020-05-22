@FXML
private void initialize() {
    hoursLabel1.textProperty().bind(Bindings.createStringBinding(() -> 
        hours.get().substring(0,1), hours));
    hoursLabel2.textProperty().bind(Bindings.createStringBinding(() -> 
        hours.get().substring(1,2), hours));
}