// Get the DOM Builder Factory
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

// Get the DOM Builder
DocumentBuilder builder = factory.newDocumentBuilder();

// Load and Parse the XML document
// document contains the complete XML as a Tree
File file = new File(PATH_TO_FILE);
InputStream inputStream = new FileInputStream(file);

Document document = builder.parse(inputStream);