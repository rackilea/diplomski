@FXML
private void initialize() throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getRessource("customElement.fxml"));
    fxmlLoader.setController(new CustomElementController()); //Or just specify the Controller in the FXML file
    myVBox.getChildren().add(fxmlLoader.load());
}