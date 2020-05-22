private void loadStocks() {
    stockService = GWT.create(StockService.class);
    stockService.getStocks(new AsyncCallback<String[]>() {
        public void onFailure(Throwable error) {
            handleError(error);
        }

        public void onSuccess(String[] symbols) {
            displayStocks(symbols);
        }
    });
}

private void displayStocks(String[] symbols) {
    for (String symbol : symbols) {
        displayStock(symbol);
    }
}

private void addStock() {
    final String symbol = newSymbolTextBox.getText().toUpperCase().trim();
    newSymbolTextBox.setFocus(true);

    // Stock code must be between 1 and 10 chars that are numbers, letters,
    // or dots.
    if (!symbol.matches("^[0-9a-zA-Z\\.]{1,10}$")) {
        Window.alert("'" + symbol + "' is not a valid symbol.");
        newSymbolTextBox.selectAll();
        return;
    }

    newSymbolTextBox.setText("");

    // Don't add the stock if it's already in the table.
    if (stocks.contains(symbol))
        return;

    addStock(new StockClient(symbol));
}

private void addStock(final StockClient stock) {
    stockService.addStock(stock.getSymbol(), new AsyncCallback<Long>() {
        public void onFailure(Throwable error) {
            handleError(error);
        }

        public void onSuccess(Long id) {
            stock.setId(id);
            displayStock(stock.getSymbol());
        }
    });
}