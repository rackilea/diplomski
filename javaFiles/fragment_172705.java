public class OutOfStockException extends Exception {

    private int stockCode;

    public OutOfStockException(int stockCode){
        super("Out of " + StockCodes.getDescription(stockCode));
        this.stockCode = stockCode;
    }

    public int getStockCode() {
        return this.stockCode;
    }
}

// Throwing one:
throw new OutOfStockException(StockCodes.WIDGETS);