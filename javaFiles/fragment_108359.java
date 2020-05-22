// getFile() method returns the input stream of a local or online file
InputStream fileStream = getFile(source);

// Read the value of the InputStream and pass it to the
// Boilerpipe DefaultExtractor in order to extract the text
String html = readFromStream(fileStream);
String text = DefaultExtractor.INSTANCE.getText(html);

// Convert the value read from fileStream to a new ByteArrayInputStream
fileStream = new ByteArrayInputStream(html.getBytes("UTF-8"));

// Extract text and metadata via Apache Tika
BodyContentHandler handler = new BodyContentHandler();
Metadata metadata = new Metadata();
ParseContext context = new ParseContext();
AutoDetectParser parser = new AutoDetectParser();
parser.parse(fileStream, handler, metadata, context);