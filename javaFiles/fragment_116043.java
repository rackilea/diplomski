try {
    orderService.updateOrder(order);
}
catch (ConcurrencyFailureException e) {
    ...
}