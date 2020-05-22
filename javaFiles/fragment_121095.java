public static void main(String[] args) throws IOException, SOAPException {

    SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory
            .newInstance();
    SOAPConnection soapConnection = soapConnectionFactory
            .createConnection();

    String url = "http://www.sk.ee/DigiDocService/DigiDocService_2_3.wsdl";
    // when I replace it with this
    // https://www.openxades.org:9443/DigiDocService I get message send
    // failed, and different error codes.

    MessageFactory messageFactory = MessageFactory.newInstance();
    InputStream is = new ByteArrayInputStream(getXmlString().getBytes());
    SOAPMessage soapMessage = messageFactory.createMessage(null, is);
    SOAPPart soapPart = soapMessage.getSOAPPart();

    String serverURI = "https://www.openxades.org:9443/DigiDocService";

    // SOAP Envelope
    SOAPEnvelope envelope = soapPart.getEnvelope();
    envelope.addNamespaceDeclaration("", serverURI);
    MimeHeaders headers = soapMessage.getMimeHeaders();
    headers.addHeader("SOAPAction", "");
    soapMessage.saveChanges();
    SOAPMessage soapResponse = soapConnection.call(soapMessage, serverURI);

    ByteArrayOutputStream out = new ByteArrayOutputStream();
    soapResponse.writeTo(out);
    String strMsg = new String(out.toByteArray());

    System.out.println(strMsg);

}

static String getXmlString() {
    return "<soapenv:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\""
            + " xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\""
            + " xmlns:dig=\"http://www.sk.ee/DigiDocService/DigiDocService_2_3.wsdl\">"
            + "<soapenv:Header/>"
            + "<soapenv:Body>"
            + " <dig:CloseSession soapenv:encodingStyle=\"http://schemas.xmlsoap.org/soap/encoding/\"> "
            + "<Sesscode xsi:type=\"xsd:int\">?</Sesscode>"
            + "</dig:CloseSession>"
            + "</soapenv:Body>"
            + "</soapenv:Envelope>";

}