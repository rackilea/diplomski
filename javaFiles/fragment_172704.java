public class OutOfStockException extends Exception {

    private int stockCode;

    public OutOfStockException(int stockCode){
        super();
        this.stockCode = stockCode;
    }

    public OutOfStockException(String s){
        super(s);
        this.stockCode = stockCode;
    }

    public int getStockCode() {
        return this.stockCode;
    }
}