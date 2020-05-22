@EnableWs
@Configuration
public class WebServiceConfig extends WsConfigurationSupport {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext applicationContext) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(applicationContext);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/ws/*");
    }

    @Bean(name = "NotMtomServices")
    public DefaultWsdl11Definition defaultWsdl11DefinitionILServices(XsdSchema notMtomServicesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ILPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(NotMtomServices.NAMESPACE_URI);
        wsdl11Definition.setSchema(notMtomServicesSchema);
        return wsdl11Definition;
    }

    @Bean(name = "MtomServices")
    public DefaultWsdl11Definition defaultWsdl11DefinitionILServicesMTOM(XsdSchema mtomServicesSchema) {
        DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
        wsdl11Definition.setPortTypeName("ILPort");
        wsdl11Definition.setLocationUri("/ws");
        wsdl11Definition.setTargetNamespace(MtomServices.NAMESPACE_URI);
        wsdl11Definition.setSchema(mtomServicesSchema);
        return wsdl11Definition;
    }

    @Bean
    @Override
    public DefaultMethodEndpointAdapter defaultMethodEndpointAdapter() {
        List<MethodArgumentResolver> argumentResolvers = new ArrayList<MethodArgumentResolver>();
        argumentResolvers.addAll(methodProcessors());

        List<MethodReturnValueHandler> returnValueHandlers = new ArrayList<MethodReturnValueHandler>();
        returnValueHandlers.addAll(methodProcessors());

        DefaultMethodEndpointAdapter adapter = new DefaultMethodEndpointAdapter();
        adapter.setMethodArgumentResolvers(argumentResolvers);
        adapter.setMethodReturnValueHandlers(returnValueHandlers);

        return adapter;
    }

    @Bean
    public List<MarshallingPayloadMethodProcessor> methodProcessors() {
        List<MarshallingPayloadMethodProcessor> retVal = new ArrayList<MarshallingPayloadMethodProcessor>();
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath(NotMtomServices.NAMESPACE_URI);
        marshaller.setMtomEnabled(false);
        retVal.add(new MarshallingPayloadMethodProcessor(marshaller));

        Jaxb2Marshaller marshallerMTOM = new Jaxb2Marshaller();
        marshallerMTOM.setContextPath(MtomServices.NAMESPACE_URI);
        marshallerMTOM.setMtomEnabled(true);
        retVal.add(new MarshallingPayloadMethodProcessor(marshallerMTOM));

        return retVal;
    }

    @Bean(name="notMtomServicesSchema")
    public XsdSchema ServicesSchema() {
        return new SimpleXsdSchema(new ClassPathResource("not_mtom_services.xsd"));
    }

    @Bean(name="mtomServicesSchema")
    public XsdSchema ServicesSchemaMTOM() {
        return new SimpleXsdSchema(new ClassPathResource("mtom_services.xsd"));
    }

}