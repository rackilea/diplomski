public class NamespaceFilter extends XMLFilterImpl {

  private static final String NAMESPACE = "http://aschema/";

  @Override
  public void endElement(String uri, String localName, String qName) throws SAXException {
    super.endElement(NAMESPACE, localName, qName);
  }

  @Override
  public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
    super.startElement(NAMESPACE, localName, qName, atts);
  }

}

...

  // Create the XMLFilter
  XMLFilter filter = new NamespaceFilter();

  // Set the parent XMLReader on the XMLFilter
  SAXParserFactory spf = SAXParserFactory.newInstance();
  SAXParser sp = spf.newSAXParser();
  XMLReader xr = sp.getXMLReader();
  filter.setParent(xr);

  // Set UnmarshallerHandler as ContentHandler on XMLFilter
  Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
  UnmarshallerHandler unmarshallerHandler = unmarshaller.getUnmarshallerHandler();
  filter.setContentHandler(unmarshallerHandler);

  // Parse the XML
  filter.parse(new InputSource(r));
  //Object result = unmarshallerHandler.getResult();  
  T t = (T) unmarshallerHandler.getResult();