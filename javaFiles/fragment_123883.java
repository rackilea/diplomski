WsDownloadInfs infs = new WsDownloadInfs();     
    WsDownloadInfsSoap proxy = infs.getWsDownloadInfsSoap();
    proxy.login(1779, "5270");


    BindingProvider prov = (BindingProvider) proxy;
    HeaderList list = (HeaderList) prov.getResponseContext().get("com.sun.xml.internal.ws.api.message.HeaderList");
    Header h =list.get(ObjectFactory._SessaoIdHeader_QNAME, true);
    SOAPMessage message = MessageFactory.newInstance().createMessage();
    h.writeTo(message);
    SOAPHeader header = message.getSOAPHeader();
    NodeList idSessaoNode = header.getElementsByTagNameNS("*", "IdSessao");
    String idSess = idSessaoNode.item(0).getChildNodes().item(0).getNodeValue();
    String guid = header.getTextContent();