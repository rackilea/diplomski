for (Iterator<Order> iterator = orders.iterator(); iterator.hasNext();) {
    Order order = iterator.next();
    if (order.equals(nOrd)) {
        iterator.remove();
    }
}