/**
 * @see "https://xerces.apache.org/xerces2-j/features.html"
 */
private XMLReader buildParser(SAXParserFactory parserFactory) throws SAXException {
    try {
        final SAXParser parser = parserFactory.newSAXParser();
        final XMLReader reader = parser.getXMLReader();
        if (!reader.getFeature("http://xml.org/sax/features/use-attributes2"))
            throw new SAXException("SAX2 parser with Attributes2 required");

        // Set your callback instances here
        reader.setEntityResolver(/*...*/);
        reader.setErrorHandler(/*...*/);
        reader.setContentHandler(/*...*/);
        reader.setProperty("http://xml.org/sax/properties/lexical-handler", /*...*/);

        reader.setFeature("http://xml.org/sax/features/namespaces", true);
        reader.setFeature("http://xml.org/sax/features/validation", true);
        reader.setFeature("http://apache.org/xml/features/validation/schema", true);

        return reader;
    } catch (ParserConfigurationException e) {
        throw new SAXException("Can't build parser", e);
    }
}