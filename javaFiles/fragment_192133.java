MessageFactory factory = MessageFactory.newInstance();           
SOAPMessage message = factory.createMessage();
SOAPBody body = message.getSOAPBody();
SOAPElement checkAccEl =  body
  .addChildElement("checkAccount", "to", "http://foo");

SOAPElement idEl = checkAccEl
  .addChildElement("id", "to", "http://foo");
idEl.addTextNode("test");

SOAPElement passwordEl = checkAccEl
  .addChildElement("password", "to", "http://foo");
passwordEl.addTextNode("test");

// print out the SOAP Message. How easy is this?!
ByteArrayOutputStream out = new ByteArrayOutputStream();
message.writeTo(out);
System.out.println(out.toString());