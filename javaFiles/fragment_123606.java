private FXMLDocumentController fXMLDocumentController;

public void setFXMLDocumentController(FXMLDocumentController fXMLDocumentController) {
    this.fXMLDocumentController = fXMLDocumentController;
}

public void newCustomer(ActionEvent e) throws IOException {
    String name = cNameTextField.getText();
    String stringCity = custCityTextField.getText();
    Customer customer = new Customer(10, name, stringCity);
    fXMLDocumentController.inflateUI(customer);//You are passing to the currently loaded controller
}