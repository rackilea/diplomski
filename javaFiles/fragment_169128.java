class OrderDto extends Order {

  public OrderDto() {
      setShippingCondition(new ShippingCondition());
  }

  public void setShippingConditionId(Integer id) {
      getShippingCondition().setId(id);
  }

}