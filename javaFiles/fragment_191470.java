public class Trade{

    // attributes of each trade that go into the Transaction log
    // properties
    private ObjectProperty<LocalDate> transactionDate;
    private StringProperty itemNum;
    private StringProperty buySell;
    private DoubleProperty volume;
    private DoubleProperty price;
    private ReadOnlyDoubleWrapper transactionFee;


    public Trade(BuySell buySell, LocalDate transactionDate, int itemNum, double volume, double price){
        this.buySell = new SimpleStringProperty(buySell.toString());
        this.transactionDate = new SimpleObjectProperty<LocalDate>(transactionDate);
        this.itemNum = new SimpleStringProperty(itemNum));
        this.volume = new SimpleDoubleProperty(volume);
        this.price = new SimpleDoubleProperty(price);
        this.transactionFee = new ReadOnlyDoubleWrapper();
        this.transactionFee.bind(this.price.multiply(this.volume).multiply(0.5));
    }

    public double getVolume(){
            return this.volume.get();
        }

    public DoubleProperty volumeProperty(){
        return this.volume;
    }

    public void setVolume(double volume){
        this.volume.set(volume);
    }


    public double getPrice(){
        return this.price.get();
    }   

    public DoubleProperty priceProperty(){
        return this.price;
    }

    public void setPrice(double price){
        this.price.set(price);
    }

    // etc etc...

    public ReadOnlyDoubleProperty transactionFeeProperty() {
        return this.transactionFee.getReadOnlyProperty();
    }

    public final double getTransactionFee() {
        return transactionFeeProperty().get();
    }

}