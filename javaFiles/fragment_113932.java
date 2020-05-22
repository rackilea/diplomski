private Pageable customSort(Pageable pageable) {
    Sort sort = pageable.getSort();
    Order order = sort.iterator().next();
    List<Order> orders = new ArrayList<>();
    // nullsFirst or nullsLast
    orders.add(new Order(order.getDirection(),order.getProperty()).nullsFirst());
    return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by(orders));
}