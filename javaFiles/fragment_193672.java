@FXML
private JFXComboBox<Drink> drinkComboBox;

private void SetComboBox() {
   this.drinkComboBox.getItems().setAll(Drink.values());
}