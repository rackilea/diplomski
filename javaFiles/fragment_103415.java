@FXML
private ComboBox<String> baudRateComboBox;

@FXML
private void initialize() {
    // called by FXMLLoader after injecting fields
    baudRateComboBox.getItems().addAll(baudRates);
}