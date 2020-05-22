@Bean
public WebServiceTemplate webServiceTemplate(){
    WebServiceTemplate webServiceTemplate = new WebServiceTemplate();
    MessageFactory msgFactory = null;
    try {
        msgFactory = MessageFactory.newInstance(SOAPConstants.DEFAULT_SOAP_PROTOCOL);
    } catch (SOAPException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    SaajSoapMessageFactory newSoapMessageFactory = new SaajSoapMessageFactory(msgFactory);
    webServiceTemplate.setMessageFactory(newSoapMessageFactory);
    webServiceTemplate.setMarshaller(marshaller());
    webServiceTemplate.setUnmarshaller(marshaller());
    return webServiceTemplate; 
}

//and then wired into the client component and set system properties for https proxy

public GetDaysUntilPasswordExpiresResponse getGetDaysUntilPasswordExpires(  ){
    System.getProperties().put("https.proxyHost", HTTPS_PROXY_HOST );  
    System.getProperties().put("https.proxyPort", HTTPS_PROXY_PORT);

    System.getProperties().put("https.proxyUser", HTTPS_PROXY_USER );  
    System.getProperties().put("https.proxyPassword", HTTPS_PROXY_PASSWORD);
    GetDaysUntilPasswordExpires requestPayload = new GetDaysUntilPasswordExpires();
    requestPayload.setContext( healthClientContext());

    log.info("Requesting expire info for :" + healthClientContext.getUserID()); 
    GetDaysUntilPasswordExpiresResponse response = (GetDaysUntilPasswordExpiresResponse) webServiceTemplate 
            .marshalSendAndReceive(
                    VENDOR_WS_URL+"/Account"
                    ,requestPayload 
                    ,new SoapActionCallback(VENDOR_WS_NAMESPACE_URL+"/IAccount/GetDaysUntilPasswordExpires"){
                        @Override
                        public void doWithMessage(WebServiceMessage message)
                                throws IOException {
                            SaajSoapMessage soapMessage = (SaajSoapMessage) message;
                            soapMessage.setSoapAction(VENDOR_WS_NAMESPACE_URL+"/IAccount/GetDaysUntilPasswordExpires");   
                        }
                    }
            );
    return response;
}