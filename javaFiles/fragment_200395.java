public enum TradingInterface {CX_CLIENT, CX_SERVER, CX_ADMIN, CX_ENGINE}

private boolean easyTrade = false;

private TradingInterface tradingInterface;

private OrderPreSelect order;
private String[] event;

public OrderPreSelect getOrder() {
    return order;
}

public void setOrder(OrderPreSelect order) {
    this.order = order;
}

public String[] getEvent() {
    return event;
}

public void setEvent(String[] event) {
    this.event = event;
}

public TradingInterface getTradingInterface() {
    return tradingInterface;
}

public void setTradingInterface(TradingInterface tradingInterface) {
    this.tradingInterface = tradingInterface;
}