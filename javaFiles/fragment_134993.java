@FXML
private void comboBoxChoice() {
    if (mainComboBox.getValue().equals("Main-1") ) {
        subComboBox.setItems(main1SubList);
        subComboBox.setValue("Main1-Sub1");
    }
    if (mainComboBox.getValue().equals("Main-2") ) {
        subComboBox.setItems(main2SubList);
        subComboBox.setValue("Main2-Sub1");
    }
    if (mainComboBox.getValue().equals("Main-3") ) {
        subComboBox.setItems(main3SubList);
        subComboBox.setValue("Main3-Sub1");
    }

}