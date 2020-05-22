private String[] getRequestAttributes(String xmlString) throws SamlException {
      Document doc = Util.createJdomDoc(xmlString);
      if (doc != null) {
        String[] samlRequestAttributes = new String[2];
        samlRequestAttributes[0] = doc.getRootElement().getAttributeValue(
          "IssueInstant");
        samlRequestAttributes[2] = doc.getRootElement().getAttributeValue(
          "ProtocolBinding");
        return samlRequestAttributes;
      } 
  }