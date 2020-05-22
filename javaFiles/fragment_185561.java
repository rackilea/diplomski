MessageFactory messageFactory = MessageFactory.newInstance();
SOAPMessage soapMessage = messageFactory.createMessage();
SOAPPart soapPart = soapMessage.getSOAPPart();

SOAPEnvelope envelope = soapPart.getEnvelope();
envelope.addNamespaceDeclaration("ns", "website");
envelope.addNamespaceDeclaration("com", "website/Common");
envelope.addNamespaceDeclaration("xm", "http://www.w3.org/2005/05/xmlmime");
SOAPBody soapBody = envelope.getBody();
SOAPElement element = soapBody.addChildElement("RequestName", "ns");
SOAPElement modelElement = element.addChildElement("model", "ns");
SOAPElement soapElement = modelElement.addChildElement("keys", "ns");
soapElement.addAttribute(envelope.createName("query"), "myquery;");
modelElement.addChildElement("instance", "ns");

soapMessage.saveChanges();
soapMessage.writeTo(System.out);