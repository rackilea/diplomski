ObservableList<Trade> observableListOfTrades =FXCollections.observableArrayList(trade ->
    new Observable[] {
        trade.transactionDateProperty(),
        trade.itemNameProperty(),
        trade.buySellProperty(),
        trade.volumeProperty(),
        trade.priceProperty().
        trade.transactionFeeProperty()
    });