class PriceCalculator {

  private final Map<ProductCode, Price> prices;

  PriceCalculator(Map<ProductCode, Price> prices) {
    this.prices = prices;
  }

  PricedOrder calculatePrice(Order order) { // doesn't deal with Mono/Flux stuff
    Double price = order.orderLines.stream()
      .map(orderLine -> prices.get(orderLine.productCode))
      .map(Price::doubleValue)
      .sum();
    return new PricedOrder(order, price);
  }
}

class PricingController {

  public Mono<PricedOrder> getPricedOrder(ServerRequest request) {
    OrderId orderId = new OrderId(request.pathVariable("orderId"));
    Mono<Order> order = orderRepository.get(orderId);
    return order.map(priceCalculator::calculatePrice)
  }
}