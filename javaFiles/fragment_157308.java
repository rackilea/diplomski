@FXML
private void addCustomer(ActionEvent event) throws IOException {

    Stage stage;
    Parent root;

    stage = new Stage();
    FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLpopUp1.fxml"));
    root = loader.load();
    PopupController popupController = loader.getController();
    stage.setScene(new Scene(root));
    stage.initModality(Modality.APPLICATION_MODAL);
    stage.initOwner(addCustomerButton.getScene().getWindow());
    stage.showAndWait();
    if (popupController.isConfirmed()) {
        // confirm button was pressed...
    }
}