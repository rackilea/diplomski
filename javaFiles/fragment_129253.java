try {
  DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
  factory.setNamespaceAware( true);
  factory.setValidating( true);

  factory.setProperty( "http://java.sun.com/xml/jaxp/properties/schemaLanguage", 
                       "http://www.w3.org/2001/XMLSchema");
  factory.setProperty( "http://java.sun.com/xml/jaxp/properties/schemaSource", 
                       "file:<your_xsd_file>");

  DocumentBuilder builder = factory.newDocumentBuilder();
  InputSource inStream = new InputSource();
  inStream.setCharacterStream(new StringReader(xmlFromWebService));
  Document document = builder.parse(inStream);

} catch ( ParserConfigurationException e) {
  e.printStackTrace();
} catch ( SAXException e) {
  e.printStackTrace();
} catch ( IOException e) {
  e.printStackTrace();
}