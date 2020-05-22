// Get the DOM Builder Factory
DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

// Get the DOM Builder
DocumentBuilder builder = factory.newDocumentBuilder();

// Load and Parse the XML document
// document contains the complete XML as a Tree
Document document = builder.parse(new File(PATH_TO_FILE));