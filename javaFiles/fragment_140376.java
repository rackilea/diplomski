@FXML
private void handleLookupProduct(ActionEvent event) {
    Inventory inv = new Inventory();

    String searchText = productsSearchInput.getText();
    if (searchText.length() != 0) {

        inv.setMainView(this);
        inv.setProductTableView(productsTableView);
        inv.lookupProduct(searchText);
    } else {
        AlertBox.display("WAIT!", "Please enter a value to search!", 450);
    }
}