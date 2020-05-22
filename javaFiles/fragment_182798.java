public class PayCheckHandler {

    public PayCheckHandler() throws Exception {
        // TODO Auto-generated method stub

        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Send SOAP Message to SOAP Server
        String url = "http://localhost:8181/PayCheckHandlerMainWebService/services/RequestHandler?wsdl";
        SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);

        // print SOAP Response
        System.out.println();
        System.out.print("Response SOAP Message:");
        soapResponse.writeTo(System.out);
        soapConnection.close();

    }


    private static SOAPMessage createSOAPRequest() throws Exception {
            MessageFactory messageFactory = MessageFactory.newInstance();
            SOAPMessage soapMessage = messageFactory.createMessage();
            SOAPPart soapPart = soapMessage.getSOAPPart();

            String serverURI = "http://service.com";

            // SOAP Envelope
            SOAPEnvelope envelope = soapPart.getEnvelope();
            SOAPHeader header = envelope.getHeader();
            SOAPBody body = envelope.getBody();


            // SOAP Body
            SOAPBodyElement element = body.addBodyElement(envelope.createName("echoTest", "", serverURI));
            element.addChildElement("echoString").addTextNode("Hello!!!");



            return soapMessage;
    }

    public static void main(String[] args) throws Exception {
        new PayCheckHandler();
    }

}