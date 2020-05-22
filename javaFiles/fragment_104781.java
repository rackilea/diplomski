@Bean
public EmbeddedServletContainerFactory servletContainerFactory() {
    TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();

    factory.addConnectorCustomizers(connector -> 
            ((AbstractProtocol) connector.getProtocolHandler()).setConnectionTimeout(10000));

    // configure some more properties

    return factory;
}