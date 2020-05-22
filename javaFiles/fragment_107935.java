import javax.xml.soap.*;

public class SOAPClientSAAJ {

    // SAAJ - SOAP Client Testing
    public static void main(String args[]) {
        String soapEndpointUrl = "https://www.w3schools.com/xml/tempconvert.asmx"; // CHANGE ME
        String soapAction = "https://www.w3schools.com/xml/CelsiusToFahrenheit"; // CHANGE ME

        callSoapWebService(soapEndpointUrl, soapAction);
    }

    private static void createSoapEnvelope(SOAPMessage soapMessage) throws SOAPException {
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String myNamespace = "tem";
        String myNamespaceURI = "http://tempuri.org/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration(myNamespace, myNamespaceURI);

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        SOAPElement soapBodyElem = soapBody.addChildElement("pay", myNamespace);

        SOAPElement merchantId = soapBodyElem.addChildElement("merchantId", myNamespace);
        merchantId.addTextNode("7507231");

        SOAPElement branch = soapBodyElem.addChildElement("branch", myNamespace);
        branch.addTextNode("Licensed Branch Name");

        SOAPElement alias = soapBodyElem.addChildElement("alias", myNamespace);
        alias.addTextNode("Service alias Name");

        SOAPElement paymentId = soapBodyElem.addChildElement("paymentId", myNamespace);
        paymentId.addTextNode("merchants payment idetificator");

        SOAPElement data = soapBodyElem.addChildElement("data", myNamespace);
        SOAPElement dataParam = data.addChildElement("param", myNamespace);
        SOAPElement dataParamKey = dataParam.addChildElement("key", myNamespace); dataParamKey.addTextNode("account");
        SOAPElement dataParamValue = dataParam.addChildElement("value", myNamespace); dataParamValue.addTextNode("account cridentials");

        SOAPElement hash = soapBodyElem.addChildElement("hash", myNamespace);
        hash.addTextNode("?");
    }

    private static void callSoapWebService(String soapEndpointUrl, String soapAction) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            SOAPMessage soapRequest = createSOAPRequest(soapAction);
            SOAPMessage soapResponse = soapConnection.call(soapRequest, soapEndpointUrl);

            // Print the SOAP Response
            System.out.println("Response SOAP Message:");
            soapResponse.writeTo(System.out);
            System.out.println();

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("\nError occurred while sending SOAP Request to Server!\nMake sure you have the correct endpoint URL and SOAPAction!\n");
            e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPRequest(String soapAction) throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();

        createSoapEnvelope(soapMessage);

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", soapAction);

        soapMessage.saveChanges();

        /* Print the request message, just for debugging purposes */
        System.out.println("Request SOAP Message:");
        soapMessage.writeTo(System.out);
        System.out.println("\n");

        return soapMessage;
    }

}