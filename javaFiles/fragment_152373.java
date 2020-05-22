@XmlElement(name = "orders")
protected List<Order> orders;

public List<Order> getOrders() {
    if (orders == null) {
        orders = new ArrayList<Order>();
    }
    return this.orders;
}