public static JAXBElement<ServiceProvider> convertToJAXBElement(ServiceProvider provider) {
    if (null == provider) {
        return null;
    }
    QName name = new QName("http://script.model.common.application.identity.carbon.wso2.org/xsd", "serviceProvider"); // Note the localpart
    return new JAXBElement(name, ServiceProvider.class, provider);
}