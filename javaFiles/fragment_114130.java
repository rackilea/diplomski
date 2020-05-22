URL url = null;
    try {
        url = new URL(endpoint + "/wsdl");
    } catch (MalformedURLException e) {
        LOG.error(e.getMessage());
    }

    javax.xml.ws.Service s = MyService.create(url, new QName(MyService.NAMESPACE, MyService.SERVICE));
    ServiceSoap port = s.getPort(ServiceSoap.class);

    Map<String, Object> reqCtx = ((BindingProvider)port).getRequestContext();
    reqCtx.put(BindingProvider.ENDPOINT_ADDRESS_PROPERTY, endpoint);
    reqCtx.put(BindingProvider.SOAPACTION_USE_PROPERTY, Boolean.TRUE);
    reqCtx.put(BindingProvider.SOAPACTION_URI_PROPERTY, actionName);

    Client client = ClientProxy.getClient(port);
    HTTPConduit http = (HTTPConduit) client.getConduit();
    HTTPClientPolicy httpClientPolicy = new HTTPClientPolicy();
    httpClientPolicy.setConnection(ConnectionType.CLOSE);
    http.setClient(httpClientPolicy);
    TLSClientParameters tls = new TLSClientParameters();
    tls.setSSLSocketFactory(sslFactory);
    tls.setDisableCNCheck(true);
    http.setTlsClientParameters(tls);