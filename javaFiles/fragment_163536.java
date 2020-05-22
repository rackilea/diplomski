import javax.xml.namespace.QName;
import javax.xml.soap.*;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;

public class Main {
    public static void main(String args[]) {
        try {
            // Create SOAP Connection
            SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
            SOAPConnection soapConnection = soapConnectionFactory.createConnection();

            // Send SOAP Message to SOAP Server
            String url = "http://ec.europa.eu/taxation_customs/vies/services/checkVatService";
            SOAPMessage soapResponse = soapConnection.call(createSOAPRequest(), url);

            // Process the SOAP Response
            printSOAPResponse(soapResponse);

            soapConnection.close();
        } catch (Exception e) {
            System.err.println("Error occurred while sending SOAP Request to Server");
            e.printStackTrace();
        }
    }

    private static SOAPMessage createSOAPRequest() throws Exception {
        MessageFactory messageFactory = MessageFactory.newInstance();
        SOAPMessage soapMessage = messageFactory.createMessage();
        SOAPPart soapPart = soapMessage.getSOAPPart();

        String serverURI = "http://ec.europa.eu/";

        // SOAP Envelope
        SOAPEnvelope envelope = soapPart.getEnvelope();
        envelope.addNamespaceDeclaration("tns1", "urn:ec.europa.eu:taxud:vies:services:checkVat:types");
        envelope.addNamespaceDeclaration("impl", "urn:ec.europa.eu:taxud:vies:services:checkVat");

        // SOAP Body
        SOAPBody soapBody = envelope.getBody();
        QName bodyQName = new QName("urn:ec.europa.eu:taxud:vies:services:checkVat:types",
                "checkVat", "tns1");
        SOAPElement soapBodyElem = soapBody.addChildElement(bodyQName);

        SOAPElement soapBodyElem1 = soapBodyElem.addChildElement(new QName("urn:ec.europa.eu:taxud:vies:services:checkVat:types",
                "countryCode", "tns1"));
        soapBodyElem1.addTextNode("...");
        SOAPElement soapBodyElem2 = soapBodyElem.addChildElement(new QName("urn:ec.europa.eu:taxud:vies:services:checkVat:types",
                "vatNumber", "tns1"));
        soapBodyElem2.addTextNode("...");

        MimeHeaders headers = soapMessage.getMimeHeaders();
        headers.addHeader("SOAPAction", serverURI  + "checkVat");

        soapMessage.saveChanges();

        /* Print the request message */
        System.out.print("Request SOAP Message = ");
        soapMessage.writeTo(System.out);
        System.out.println();

        return soapMessage;
    }

    private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        Source sourceContent = soapResponse.getSOAPPart().getContent();
        System.out.print("\nResponse SOAP Message = ");
        StreamResult result = new StreamResult(System.out);
        transformer.transform(sourceContent, result);
    }
}