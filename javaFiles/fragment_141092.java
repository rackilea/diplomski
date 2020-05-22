// you can of course define the text field in FXML if you prefer...
TextField newAcronymTextField = new TextField();

newAcronymTextField.setOnAction(e -> {
    clientAcronymTable.getItems().add(newAcronymTextField.getText());
    newAcronymTextField.clear();
});