public static void main(String[] args) 
{
    try {

    //Create a SOAPMessage
    SOAPConnectionFactory soapConnectionFactory = SOAPConnectionFactory.newInstance();
    SOAPConnection connection = soapConnectionFactory.createConnection();
    SOAPFactory soapFactory = SOAPFactory.newInstance();
    MessageFactory factory = MessageFactory.newInstance();
    SOAPMessage message = factory.createMessage();
    SOAPHeader header = message.getSOAPHeader();
    SOAPBody body = message.getSOAPBody();
    header.detachNode();

    Name bodyName = soapFactory.createName("getCalculation", "m", "http://localhost:8080/");
    SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

            //Insert Content
    Name name = envelope.createName("number1");
    SOAPElement symbol = bodyElement.addChildElement(name);
    symbol.addTextNode("10");
    name = envelope.createName("number2");
    symbol = bodyElement.addChildElement(name);
    symbol.addTextNode("20");

            System.out.println("\n Request: \n");
            message.writeTo(System.out);
            System.out.println();

            // Create an endpint point which is either URL or String type
    URL endpoint = new URL("http://localhost:8080/WebServiceName/OperationName");

            //Send a SOAPMessage (request) and then wait for SOAPMessage (response)
    SOAPMessage response = connection.call(message, endpoint);

    // Get the response from the webservice.                
    SOAPBody soapBody = response.getSOAPBody();

    System.out.println("\n Response: \n");
    TransformerFactory transformerfactory = TransformerFactory.newInstance();
    Transformer transformer = transformerfactory.newTransformer();
    Source sourceContent = response.getSOAPPart().getContent();
    StreamResult result = new StreamResult(System.out);
    transformer.transform(sourceContent, result);
    System.out.println();
    String resp = response.getSOAPBody().getElementsByTagName("return").item(0).getFirstChild().getNodeValue();
    System.out.println("Answer is: " + resp);

    connection.close();

    } catch (Exception ex) {
        ex.printStackTrace();
    }
}