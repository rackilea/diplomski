@Override
public Page<OrderDto> findAll(Pageable pageable) {
  Page<OrderDto> page = orderDao.findByIsEnabledTrue(pageable, OrderDto.class);
  page = page.map(this :: transformOrderDto);
  return page;
}

private OrderDto transformOrderDto(final OrderDto order) {
  order. setFormattedCreatedAt(new SimpleDateFormat("dd-M-yyyy").format(order.getCreatedAt()));
  return order;
}