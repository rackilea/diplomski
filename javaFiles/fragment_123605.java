@FXML
private void handleButtonAction(ActionEvent event) throws IOException {
    FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/com/newcustomer/NewCustomer.fxml"));
    Parent parent = fXMLLoader.load();
    NewCustomerController controller = fXMLLoader.getController();
    controller.setFXMLDocumentController(this); // Pass this controller to NewCustomerController
    Stage stage = new Stage();
    Scene scene = new Scene(parent);
    stage.setScene(scene);
    stage.show();
}