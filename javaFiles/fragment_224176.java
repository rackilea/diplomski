MessageFactory messageFactory = MessageFactory.newInstance();
SOAPMessage soapMessage = messageFactory.createMessage();

// Retrieve different parts
SOAPPart soapPart = soapMessage.getSOAPPart();
SOAPEnvelope soapEnvelope = soapMessage.getSOAPPart().getEnvelope();

// Two ways to extract headers
SOAPHeader soapHeader = soapEnvelope.getHeader();
soapHeader = soapMessage.getSOAPHeader();

// Two ways to extract body
SOAPBody soapBody = soapEnvelope.getBody();
soapBody = soapMessage.getSOAPBody();

// To add some element
SOAPFactory soapFactory = SOAPFactory.newInstance();
Name bodyName  = soapFactory.createName("getEmployeeDetails","ns1","urn:MySoapServices");
SOAPBodyElement purchaseLineItems = soapBody.addBodyElement(bodyName);
Name childName = soapFactory.createName("param1");
SOAPElement order = purchaseLineItems.addChildElement(childName);
order.addTextNode("1016577");