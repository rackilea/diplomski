@Bean(name="updateContactService")
public DefaultWsdl11Definition defaultWsdl11Definition() throws Exception {
    DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
    wsdl11Definition.setPortTypeName("updateContactPort");
    wsdl11Definition.setLocationUri("/ws/updateContact");
    wsdl11Definition.setTargetNamespace("http://spring.io/guides/gs-producing-web-service");
    wsdl11Definition.setSchemaCollection(updateContactXsd());
    return wsdl11Definition;
}   

@Bean
public XsdSchemaCollection updateContactXsd() throws Exception {
    CommonsXsdSchemaCollection xsds = new CommonsXsdSchemaCollection(new ClassPathResource("xsds/contact/outboundMessage.xsd"));
    xsds.setInline(true);  <-------------------
    return xsds;
}