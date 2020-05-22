private void registerEndpointService(GenericApplicationContext genericApplicationContext, Environment env, String endpointName, String locationUri) {
  Resource resource = genericApplicationContext.getResource(env.getProperty(SOAP_ENDPOINTS + endpointName + ".wsdl.location"));
  SimpleXsdSchema schema = new SimpleXsdSchema(resource);
  genericApplicationContext.registerBean(endpointName + "Schema", SimpleXsdSchema.class, () -> schema);

  String portTypeName = env.getProperty(SOAP_ENDPOINTS + endpointName + ".portType.name");
  String targetNamespace = env.getProperty(SOAP_ENDPOINTS + endpointName + ".target.namespace");

  genericApplicationContext.registerBean(endpointName + "Service",
    DefaultWsdl11Definition.class,
    () -> {
      DefaultWsdl11Definition wsdl11Definition = new DefaultWsdl11Definition();
      wsdl11Definition.setPortTypeName(portTypeName);
      wsdl11Definition.setLocationUri(locationUri);
      wsdl11Definition.setTargetNamespace(targetNamespace);
      wsdl11Definition.setSchema(schema);

      return wsdl11Definition;
    });
}