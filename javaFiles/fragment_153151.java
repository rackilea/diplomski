public Mono<List<Order>> orders() {
    return rest.orders()
        .map(r -> toList(r));
}

private List<Order> toList(Resources<Resource<Order>> resources) {
    List<Order> orders = new ArrayList<>();
    resources.forEach(r -> orders.add(r.getContent());
    return orders;
}