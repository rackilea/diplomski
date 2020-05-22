final XMLInputFactory inputFactory;
final XMLStreamReader reader;
final InputStream     stream;

inputFactory = XMLInputFactory.newInstance();
stream       = new FileInputStream(file);
reader       = inputFactory.createXMLStreamReader(stream);