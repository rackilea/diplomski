public static double calculateProfit(Collection<MarketOrder> orders) {
    if (orders == null) {
        throw new NullPointerException("orders is null");
    }

    int buyTotal = 0, sellTotal = 0, buyMoney = 0, sellMoney = 0; 
    for (MarketOrder order : orders) { 
        if (order.type == MarketOrder.OrderType.BUY) { // accumulate the units bought and money
            buyTotal += order.amount; 
            buyMoney += order.money * order.amount; 
        } else {
            sellTotal += order.amount; 
            sellMoney += order.money * order.amount;
        }
    }

    if (buyTotal != sellTotal) { 
        throw new IllegalArgumentException("buyTotal != sellTotal");
    }

    return ((double)sellMoney/(double)buyMoney) - 1; 
}