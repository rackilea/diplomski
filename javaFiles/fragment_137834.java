private void initiateService() throws Exception{

    WebService_Service webService_service = new WebService_Service();

    webService_service.setHandlerResolver(new HandlerResolver() {
        @Override
        public List<Handler> getHandlerChain(PortInfo portInfo) {
            List<Handler> handlerList = new ArrayList<>();
            SOAPLoggingHandler soapLoggingHandler = new SOAPLoggingHandler();
            handlerList.add(soapLoggingHandler);
            return handlerList;
        }
    });

    webServicePort = webService_service.getPort(WebService.class);

    Client client = ClientProxy.getClient(webServicePort);

    Endpoint cxfEndpoint = client.getEndpoint();

    Map<String, Object> props = ((BindingProvider) webServicePort).getRequestContext();
    props.put("ws-security.username", PravoRuConstants.USERNAME);
    props.put("ws-security.password", PravoRuConstants.PASSWORD);

    props.put(WSHandlerConstants.ACTION, WSHandlerConstants.USERNAME_TOKEN);
    props.put(WSHandlerConstants.USER, PravoRuConstants.USERNAME);
    props.put(WSHandlerConstants.PASSWORD_TYPE, WSConstants.PW_TEXT);

    props.put(WSHandlerConstants.PW_CALLBACK_CLASS, PravoRuPasswordHandler.class.getName());

    WSS4JOutInterceptor wssOut = new WSS4JOutInterceptor(props);
    cxfEndpoint.getOutInterceptors().add(wssOut);

}