// If parsing was successful...
    if (succeed) {
        tempStock = new Stock(); // or however you instantiate this object
        tempStock.setTicker(ticker);
        tempStock.setNumberOfShares(num_shares);
        tempStock.setStockName(stockName);