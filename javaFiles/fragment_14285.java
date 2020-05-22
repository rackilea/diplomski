SOAPFactory factory = OMAbstractFactory.getSOAP11Factory();
SOAPEnvelope envelope = factory.getDefaultEnvelope();
OMElement xmlElement= factory.createOMElement("search", envelope.getDefaultNamespace());
envelope.getBody().addChild(xmlElement);

OMTextImpl omText = (OMTextImpl) xmlElement.getOMFactory().createOMText(xmlElement, xmlForCdata, XMLStreamConstants.CDATA);
xmlElement.addChild(omText);

System.out.println(envelope.toStringWithConsume());