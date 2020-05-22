private String[] getRequestAttributes(String xmlString) throws SamlException {
      Document doc = Util.createJdomDoc(xmlString);
      if (doc != null) {
        Namespace saml = Namespace.get("urn:oasis:names:tc:SAML:2.0:assertion");
        String[] samlRequestAttributes = new String[3];
        Element root = doc.getRootElement();
        samlRequestAttributes[0] = root.getAttributeValue("IssueInstant");
        samlRequestAttributes[1] = root.getAttributeValue("ProtocolBinding");
        samlRequestAttributes[2] = root.getChild("Issuer", saml).getText();

        return samlRequestAttributes;
      } 
  }