@FXML
void addMoreButton(ActionEvent event) {
    Button source = (Button) event.getSource();
    source.setOnAction(null); // remove event handler

    Button newButton = new Button("+");
    newButton.setOnAction(this::addMoreButton);

    vboxTest.getChildren().add(newButton);
}