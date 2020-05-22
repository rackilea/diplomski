/* Connect to the service */
ClientProxyFactoryBean factoryBean = new JaxWsProxyFactoryBean();
factoryBean.setServiceClass(MyService.class);
factoryBean.setAddress("service-url");
myService = (MyService) factoryBean.create();
/* Retrive HTTP client policy and set the receive timeout */
Client client = ClientProxy.getClient(myService);
HTTPConduit httpConduit = (HTTPConduit) client.getConduit();
HTTPClientPolicy httpClientPolicy = httpConduit.getClient();
httpClientPolicy.setReceiveTimeout(timeoutMilliseconds);