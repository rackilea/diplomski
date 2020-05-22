public Trade(BuySell buySell, LocalDate transactionDate, int itemNum, double volume, double price){
    this.buySell = new SimpleStringProperty(buySell.toString());
    this.transactionDate = new SimpleObjectProperty<LocalDate>(transactionDate);
    this.itemNum = new SimpleStringProperty(itemNum));
    this.volume = new SimpleDoubleProperty(volume);
    this.price = new SimpleDoubleProperty(price);
    this.transactionFee = this.price.multiply(this.volume).multiply(0.5);
}