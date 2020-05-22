@FXML
void showParts(){

    bikePartList.clear();

    bikePartList.appendText("Name\tNumber\tListPrice\tSalePrice\tQuantity\tOnSale?\n");

    Warehouse selectedWarehouse = warehouseComboBox.getSelectionModel().getSelectedItem();

    // I think this is what you're trying to do:
    bikePartList.appendText(selectedWarehouse.printAll()); //what do I do here?


}