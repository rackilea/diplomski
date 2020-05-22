SOAPMessage soapMessage = message.getContent(SOAPMessage.class);
SOAPBody env = message.getSOAPPart().getEnvelope().getBody();
javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(env);
StringWriter stringResult = new StringWriter();
javax.xml.transform.TransformerFactory.newInstance().newTransformer().transform(source, new StreamResult(stringResult));
String soapBody = stringResult.toString();