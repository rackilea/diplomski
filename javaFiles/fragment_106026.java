// strip unwanted whitespace
XMLInputFactory inputFactory = XMLInputFactory.newInstance();
XMLEventReader eventReader = inputFactory
    .createXMLEventReader(ReadXml.class.getResourceAsStream("level.xml"));
eventReader = inputFactory.createFilteredReader(eventReader,
    new WhitespaceFilter());

// parsing the xml
Source sourceRoot = (Source) unmarshaller.unmarshal(eventReader);

//TODO: proper error + stream handling