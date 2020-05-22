ObservableList<Trade> observableListOfTrades =FXCollections.observableArrayList(trade ->
        new Observable[]{
                trade.transactionDateProperty(),
                trade.stockTickerProperty(),
                trade.buySellProperty(),
                trade.volumeProperty(),
                trade.priceProperty(),
        }
    );