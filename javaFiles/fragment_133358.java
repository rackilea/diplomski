public abstract class Part {
    private int partID;
    private String name;
    private double price;
    private int inStock;
    private int min;
    private int max;
    static int partIDCount = 1;
    private SimpleStringProperty tablePartID;
    private SimpleStringProperty tablePartName;
    private SimpleStringProperty tableInvLvl;
    private SimpleStringProperty tablePrice;



    void setName(String name){
        this.name = name;
    }

    String getName(){
        return this.name;
    }

    void setPrice(double price){
        this.price = price;
    }

    double getPrice(){
        return this.price;
    }

    void setInStock(int inStock){
        this.inStock = inStock;
    }

    int getInStock(){
        return this.inStock;
    }

    void setMin(int min){
        this.min = min;
    }

    int getMin(){
        return this.min;
    }

    void setMax(int max){
        this.max = max;
    }

    int getMax(){
        return this.max;
    }

    void setPartID(int partID){
        this.partID = partID;
    }

    int getPartID(){
        return this.partID;
    }

    void setTablePartID(){
        this.tablePartID = new SimpleStringProperty(Integer.toString(this.partID));
    }

    SimpleStringProperty getTablePartID(){
        return this.tablePartID;
    }

    void setTablePartName(){
        this.tablePartName = new SimpleStringProperty(this.name);
    }

    SimpleStringProperty getTablePartName(){
        return this.tablePartName;
    }

    void setTableInvLvl(){
        this.tableInvLvl = new SimpleStringProperty(Integer.toString(inStock));
    }

    SimpleStringProperty getTableInvLvl(){
        return this.tableInvLvl;
    }

    void setTablePrice(){
        this.tablePrice = new SimpleStringProperty(Double.toString(price));
    }

    SimpleStringProperty getTablePrice(){
        return this.tablePrice;
    }

    public SimpleStringProperty tablePartIDProperty() {
        return tablePartID;
    }

    public void setTablePartID(String tablePartID) {
        this.tablePartID.set(tablePartID);
    }

    public SimpleStringProperty tablePartNameProperty() {
        return tablePartName;
    }

    public void setTablePartName(String tablePartName) {
        this.tablePartName.set(tablePartName);
    }

    public SimpleStringProperty tableInvLvlProperty() {
        return tableInvLvl;
    }

    public void setTableInvLvl(String tableInvLvl) {
        this.tableInvLvl.set(tableInvLvl);
    }

    public SimpleStringProperty tablePriceProperty() {
        return tablePrice;
    }

    public void setTablePrice(String tablePrice) {
        this.tablePrice.set(tablePrice);
    }
}