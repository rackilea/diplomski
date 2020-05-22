NotificationWebService service = new NotificationWebService();
NotificationWebServiceSoap serviceSoap = service.getNotificationWebServiceSoap();

BindingProvider bindingProvider = (BindingProvider) serviceSoap;
bindingProvider.getRequestContext().put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, "https://wsdl.location.com");

String xmlString = serviceSoap.getRSAPublicKeyXMLString();