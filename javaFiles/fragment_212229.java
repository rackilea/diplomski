sax = factory.newSAXParser();
try {
  // Here I am using an InputSource wrapping a StringReader.
  sax.parse(new InputSource(new StringReader(xml)), this);
} catch (SAXException ex) {
  log.warning("XMLParser failed on: "+xml, ex);
}