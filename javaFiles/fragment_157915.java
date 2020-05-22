@FXML
private void AddTextField(ActionEvent event) {
    final HBox parent = new HBox(5.0); // 5.0 is the distance between the field and the button; hbox is the parent of both

    TextField field = new TextField();
    Button button = new Button("Close"); // the button to "close" the textfield
    button.setOnAction((e) -> pane_main_grid.getChildren().remove(parent)); // button click removes the hbox
    button.setPrefSize(100, 27); // only if you're using a custom font / styling
    HBox.setHgrow(field, Priority.ALWAYS); // field should always grow
    HBox.setHgrow(button, Priority.NEVER); // button should never grow

    parent.getChildren().setAll(field, button); // add the textfield and the button to the hbox
    pane_main_grid.getChildren().add(parent); // add the hbox to your main grid
}