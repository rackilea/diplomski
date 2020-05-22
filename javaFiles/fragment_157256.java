./third.xsd   # probably not the real name, but you no tell
./types/alr_msg_type.xsd
./types/vms_header.xsd

public static void main( String[] args ) throws Exception {
  Handler handler = new Handler();
  DocumentBuilder parser =
    DocumentBuilderFactory.newInstance().newDocumentBuilder();
  parser.setErrorHandler( handler );
  try {
    Document document = parser.parse(new File("x.xml"));
    SchemaFactory factory = 
      SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Source schemaFile = new StreamSource(new File("third.xsd"));
    Schema schema = factory.newSchema(schemaFile);
    Validator validator = schema.newValidator();
    validator.setErrorHandler( handler );
    // validate the DOM tree
    try {
      validator.validate(new DOMSource(document));
    } catch (SAXException e) {
      // ...
      System.out.println( "VAlidation error" );
    }
  } catch (SAXParseException e) {
    // syntax error in XML document     
    System.out.println( "Syntax error" );
  }
}