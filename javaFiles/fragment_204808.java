File xmlFile = new File("xml-files/contacts.xml");
 SAXParserFactory factory = SAXParserFactory.newInstance();

 factory.setValidating(true);

 SAXParser parser = factory.newSAXParser();                              
 parser.setProperty("http://java.sun.com/xml/jaxp/properties/schemaLanguage", "http://www.w3.org/2001/XMLSchema");

 SAXReader reader = new SAXReader(parser.getXMLReader());
 reader.setEntityResolver(new EntityResolver2Impl(xmlFile));
 reader.setValidation(true);
 reader.read(new FileReader(xmlFile));