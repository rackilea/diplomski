@Autowired
public RestTokenUserOnboardRoute userOnboardRoute;
@Autowired
public RestTokenProducerRoute serviceTokenProducerRoute;

@Autowired
private RestTokenProducerRoute tokenObj;

@Override
protected CamelContext createCamelContext() throws Exception {
    SimpleRegistry registry = new SimpleRegistry(); 
    registry.put("tokenObj", tokenObj); //the tokenObj bean,which can be used anywhere in the camelcontext
    SpringCamelContext camelContext = new SpringCamelContext();
    camelContext.setRegistry(registry); //add the registry
    camelContext.setApplicationContext(getApplicationContext());
    camelContext.addComponent("salesforce", salesforceComponent());
    camelContext.getTypeConverterRegistry().addTypeConverter(DomainUserRequest.class, MyUser__c.class, new MyTypeConverter());
    camelContext.addRoutes(route()); //Some other route
    camelContext.addRoutes(serviceTokenProducerRoute); //Token producer Route
    camelContext.addRoutes(userOnboardRoute); //Subsequent API call route
    camelContext.start();
    return camelContext;
}