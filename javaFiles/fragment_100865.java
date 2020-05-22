@FXML
void addMoreButton(ActionEvent event) {
    Node source = (Node) event.getSource();

    Button newButton = new Button("+");
    newButton.setOnAction(this::addMoreButton);

    vboxTest.getChildren().add(vboxTest.getChildren().indexOf(source) + 1, newButton);
}