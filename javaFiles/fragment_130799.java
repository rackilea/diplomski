private Order findMatchingOrder(String id, List<Order> orders) {
    for (Order o: orders) {
        if (o.getId().equals(id)) 
            return o;

        Order found = findMatchingOrder(id, o.getOrders());
        if (found != null)
            return found;
    }
    return null;
}