private static SOAPMessage createSOAPRequest() throws Exception {

    MessageFactory messageFactory = MessageFactory.newInstance();
    SOAPMessage soapMessage = messageFactory.createMessage();
    SOAPPart soapPart = soapMessage.getSOAPPart();


    SOAPEnvelope envelope = soapPart.getEnvelope();      
    envelope.removeNamespaceDeclaration(envelope.getPrefix());
    envelope.addNamespaceDeclaration("soap","http://schemas.xmlsoap.org/soap/envelope/");
    envelope.setPrefix("soap");              
    envelope.addNamespaceDeclaration("xsi","http://www.w3.org/2001/XMLSchema-instance");
    envelope.addNamespaceDeclaration("xsd","http://www.w3.org/2001/XMLSchema"); 
    SOAPHeader header=soapMessage.getSOAPHeader();                      
    header.setPrefix("soap");       
    SOAPBody soapBody = envelope.getBody();
    soapBody.setPrefix("soap");
    SOAPElement root=soapBody.addChildElement(new QName("http://tempuri.org/","SendRequest"));      
    SOAPElement request=root.addChildElement(new QName("http://paygo24.com/v3/protocol","request"));       
    request.setAttribute("xsi:type", "RegisterCheckRequest");
    request.setAttribute("Id","7a646d45-ee2f-4b1c-8de8-780c416fbbd0");
    request.setAttribute("Service","42");        
    SOAPElement paymentParameters =request.addChildElement(new QName(" ","PaymentParameters"));
    SOAPElement parameter=paymentParameters.addChildElement("Parameter");        
    parameter.setAttribute("Name","account");
    parameter.setAttribute("Value", "08374829");
    root.addChildElement("pointId").setValue("46");       
    root.addChildElement("password").setValue("4QrcOUm6Wau+VuBX8g+IPg==");           
    soapMessage.saveChanges();

    soapMessage.writeTo(System.out);


    return soapMessage;
}