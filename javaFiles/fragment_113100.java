protected Order createOrder(String someParam) {
  Order order = Mockito.mock(Order.class); // create mock object
  // configure mock to return someParam when 
  //  String Order#getSomeParam() gets invoked
  Mockito.doReturn(someParam).when(order).getSomeParam(); 
  return order;
}