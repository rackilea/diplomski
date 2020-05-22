/**
 * Defines the {@link SaajSoapMessageFactory} as a Spring managed bean.
 * 
 * Note: we need a Soap implementation of a MessageFactory to create soap messages in Spring-WS.
 * 
 * @return the messageFactory
 */
@Bean
public SaajSoapMessageFactory messageFactory() {

    return new SaajSoapMessageFactory();
}

/**
 * Defines the {@link WebServiceMessageReceiverHandlerAdapter} as a Spring managed bean.
 * 
 * Note: We need to add this bean to the context in order for the DispatcherServlet to delegate to a MessageDispatcher 
 * (as opposed to Controllers).  The MessageDispatcher is necessary for Spring-WS.
 * 
 * @return the webServiceMessageReceiverHandlerAdapter
 */
@Bean
public WebServiceMessageReceiverHandlerAdapter webServiceMessageReceiverHandlerAdapter() {

    WebServiceMessageReceiverHandlerAdapter adapter = new WebServiceMessageReceiverHandlerAdapter();
    adapter.setMessageFactory(messageFactory());

    return adapter;
}

/**
 * Defines the {@link SimpleUrlHandlerMapping} as a Spring managed bean.
 * 
 * Note: In order for the DispatcherServlet to handle SOAP message, we were forced to add the {@link WebServiceMessageReceiverHandlerAdapter}
 * to the context. By explicitely adding that bean to the context, we are now forced to also add this bean to handle REST messages.
 * 
 * @return the simpleUrlHandlerMapping
 */
@Bean
public SimpleUrlHandlerMapping simpleUrlHandlerMapping() {

    SimpleUrlHandlerMapping simpleUrlHandlerMapping = new SimpleUrlHandlerMapping();
    simpleUrlHandlerMapping.setDefaultHandler(messageDispatcher());
    Properties urlProperties = new Properties();

    urlProperties.put("Lookup.wsdl", "Lookup");

    simpleUrlHandlerMapping.setMappings(urlProperties);
    simpleUrlHandlerMapping.setDefaultHandler(messageDispatcher());

    return simpleUrlHandlerMapping;
}

/**
 * Defines the {@link SoapMessageDispatcher} as a Spring managed bean.
 * 
 * Note: Dispatches SOAP messages.
 * 
 * @return the messageDispatcher
 */
@Bean 
public SoapMessageDispatcher messageDispatcher() {

    return new SoapMessageDispatcher();
}

/**
 * Defines the {@link SimpleControllerHandlerAdapter} as a Spring managed bean.
 * 
 * Note: In order for the DispatcherServlet to handle SOAP messages, we were forced to add the {@link WebServiceMessageReceiverHandlerAdapter}
 * to the context.  By explicitely adding that bean to the context, the default adapters were not automatically added to handle 
 * standard MVC Controllers.  We must add this bean to do that.
 * 
 * @return the simpleControllerHandlerAdapter
 */
@Bean
public SimpleControllerHandlerAdapter simpleControllerHandlerAdapter() {

    return new SimpleControllerHandlerAdapter();
}