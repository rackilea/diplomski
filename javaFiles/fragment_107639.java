private void alterSoapEnvelope(SaajSoapMessage soapResponse) {
    try {
      SOAPMessage soapMessage = soapResponse.getSaajMessage();
      SOAPPart soapPart = soapMessage.getSOAPPart();
      SOAPEnvelope envelope = soapPart.getEnvelope();
      SOAPHeader header = soapMessage.getSOAPHeader();
      SOAPBody body = soapMessage.getSOAPBody();
      SOAPFault fault = body.getFault();
      envelope.removeNamespaceDeclaration(envelope.getPrefix());
      envelope.addNamespaceDeclaration(PREFERRED_PREFIX, SOAP_ENV_NAMESPACE);
      envelope.setPrefix(PREFERRED_PREFIX);
      header.setPrefix(PREFERRED_PREFIX);
      body.setPrefix(PREFERRED_PREFIX);
      if (fault != null) {
        fault.setPrefix(PREFERRED_PREFIX);
      }
    } catch (SOAPException e) {
      e.printStackTrace();
    }
  }