class MarketOrder {
    public static enum OrderType {
        BUY, 
        SELL, 
    }

    private final MarketOrder.OrderType type; 
    private final int amount; 
    private final int money; 

    public MarketOrder(MarketOrder.OrderType type, int amount, int money) { 
        if (amount < 1 || money < 1) { 
            throw new IllegalArgumentException(); 
        }

        this.type = type; 
        this.amount = amount; 
        this.money = money; 
    }
}