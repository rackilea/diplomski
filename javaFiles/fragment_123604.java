public void newCustomer(ActionEvent e) throws IOException {
    String name = cNameTextField.getText();
    String stringCity = custCityTextField.getText();
    Customer customer = new Customer(10, name, stringCity);
    FXMLLoader fXMLLoader = new FXMLLoader(getClass().getResource("/mytableview/FXMLDocument.fxml"));
    fXMLLoader.load(); // YOU ARE MISSING THIS LINE
    FXMLDocumentController fXMLDocumentController = fXMLLoader.<FXMLDocumentController>getController();
    fXMLDocumentController.inflateUI(customer); // Getting NPE at this line.
}