URL url = new URL(xmlFileLocation);
URLConnection connection = url.openConnection();
// Prevent JavaWebStart from returning cached copy.
connection.setUseCaches(false);

// Now fetch the content, e.g.
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = dbf.newDocumentBuilder(); 
Document doc = db.parse(connection.getInputStream());