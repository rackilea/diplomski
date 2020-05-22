import javax.xml.soap.*;
import javax.xml.transform.*;
import javax.xml.transform.stream.*;

public class SoapCall  {

public static void main(String args[]) {
    try {
        // Create SOAP Connection
        SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
        SOAPConnection soapConnection = soapConnectionFactory.createConnection();

        // Send SOAP Message to SOAP Server.
        String url = "Your URL";
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

    String YourUsername = "UserName";
    String YourPassword = "Password";

    MessageFactory messageFactory = MessageFactory.newInstance();
    SOAPMessage soapMessage = messageFactory.createMessage();
    SOAPPart soapPart = soapMessage.getSOAPPart();

    String serverURI = "Your URL";

    // SOAP Envelope
    SOAPEnvelope envelope = soapPart.getEnvelope();
    envelope.addNamespaceDeclaration("Login", serverURI);


    SOAPBody soapBody = envelope.getBody();

    SOAPElement soapBodyElem = soapBody.addChildElement("Login");

    SOAPElement soapBodyElem2 = soapBodyElem.addChildElement("UserName");
    soapBodyElem2.addTextNode(YourUserName);
    SOAPElement soapBodyElem3 = soapBodyElem.addChildElement("Password");
    soapBodyElem3.addTextNode(YourPassword);

    MimeHeaders headers = soapMessage.getMimeHeaders();
    headers.addHeader("SOAPAction", serverURI  + "Login");

    soapMessage.saveChanges();

    /* Print the request message */
    System.out.print("Request SOAP Message = ");
    soapMessage.writeTo(System.out);
    System.out.println();

    return soapMessage;
}

/**
 * Method used to print the SOAP Response
 */
private static void printSOAPResponse(SOAPMessage soapResponse) throws Exception {
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    Source sourceContent = soapResponse.getSOAPPart().getContent();
    System.out.print("\nResponse SOAP Message = ");
    StreamResult result = new StreamResult(System.out);
    transformer.transform(sourceContent, result);
}