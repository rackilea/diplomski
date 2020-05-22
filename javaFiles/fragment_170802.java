@Bean
public WsdlDefinitionHandlerAdapter wsdlDefinitionHandlerAdapter() {

    WsdlDefinitionHandlerAdapter wsdlDefinitionHandlerAdapter = new WsdlDefinitionHandlerAdapter();
    wsdlDefinitionHandlerAdapter.setTransformLocations(true);

    return wsdlDefinitionHandlerAdapter;
}