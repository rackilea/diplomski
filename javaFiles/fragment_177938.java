@Configuration
public class StoreServiceConfig {

    @Bean
    public StoreWS storeWS() throws IOException {
      JaxWsPortProxyFactoryBean factoryBean = new JaxWsPortProxyFactoryBean();
      factoryBean.setServiceInterface(StoreWS.class);
      factoryBean.setWsdlDocumentUrl(new ClassPathResource("/wsdl/StoreWS.wsdl").getURL());
      factoryBean.setNamespaceUri("urn_store");
      factoryBean.setServiceName("StoreWSService");
      factoryBean.setEndpointAddress("https://10.34.45.82/storeservice/services/StoreWS");
      factoryBean.setUsername("testuser");
      factoryBean.setPassword("testpassword");

      factoryBean.setHandlerResolver(handlerResolver());

      factoryBean.afterPropertiesSet();
      return (StoreWS) factoryBean.getObject();
  }

  public HandlerResolver handlerResolver() {
    return new HandlerResolver() {

        public List<Handler> getHandlerChain(PortInfo portInfo) {
            List<Handler> handlerChain = new ArrayList<Handler>();
            handlerChain.add(new LoggingHandler());
            return handlerChain;
        }

    };
 }