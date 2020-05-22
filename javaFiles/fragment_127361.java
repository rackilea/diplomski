static class MyNamespaceContext implements NamespaceContext {
  @Override
  public String getNamespaceURI(String prefix) {
    if(prefix == null) {
      throw new IllegalArgumentException();
    } else if(prefix.equals(XMLConstants.DEFAULT_NS_PREFIX)) {
      return XMLConstants.NULL_NS_URI;
    } else if(prefix.equals(XMLConstants.XML_NS_PREFIX)) {
      return XMLConstants.XML_NS_URI;
    } else if(prefix.equals(XMLConstants.XMLNS_ATTRIBUTE)) {
      return XMLConstants.XMLNS_ATTRIBUTE_NS_URI;
    } else if(prefix.equals("m")) {
      return "http://www.somescheme";
    } else if(prefix.equals("doc")) {
      return "http://www.somescheme";
    } else {
      return XMLConstants.NULL_NS_URI;
    }
  }

  @Override
  public String getPrefix(String namespaceURI) {
    throw new UnsupportedOperationException();
  }

  @Override
  public Iterator getPrefixes(String namespaceURI) {
    throw new UnsupportedOperationException();
  }
}