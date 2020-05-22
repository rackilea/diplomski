NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
priceCol.setCellFactory(tc -> new TableCell<Product, Double>() {

    @Override
    protected void updateItem(Double price, boolean empty) {
        super.updateItem(price, empty);
        if (empty) {
            setText(null);
        } else {
            setText(currencyFormat.format(price));
        }
    }
});