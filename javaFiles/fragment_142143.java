public OrderInfo findOrder(SearchOrderCriteria searchCriteria) {

    OrderInfo order = new OrderInfo();
    order.setItemId(searchCriteria.getItemId());
    order.setOrderId(searchCriteria.getOrderId());
    order.setDeliveryId(searchCriteria.getDeliveryId());
    order.setPacketId(searchCriteria.getPacketId());

    Example<OrderInfo> example = Example.of(order);
    return orderRepository.findOne(example);
}