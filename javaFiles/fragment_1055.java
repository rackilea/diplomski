final XMLInputFactory     inputFactory;
final XMLStreamReader     reader;
final InputStream         stream;
final CountingInputStream countingStream;

inputFactory   = XMLInputFactory.newInstance();
stream         = new FileInputStream(file);
countingStream = new CountingStream(stream);
reader         = inputFactory.createXMLStreamReader(countingStream);