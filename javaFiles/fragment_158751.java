//Set a handler 
proxyFactory.setHandlers( Arrays.asList((Handler) new TokenHandler(Token)));
OrderService orderServicePort=  (myService) proxyFactory.create();

//Call service method, as SOAP message has desired dynamic header
orderServicePort.getXXX()