File folder = new File("C:\\Users\\Lozanovski\\Desktop\\TransportMe");
DocumentBuilder docBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();

if (folder.isDirectory()) {
    for (File file : folder.listFiles()) {
        Document doc = docBuilder.parse(file); // create an XML document
        file.delete(); // delete the file
    }
}