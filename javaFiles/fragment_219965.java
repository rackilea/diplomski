public void serializeXmlFiles(ArrayList<File> files) throws ParserConfigurationException, TransformerException {
    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    Document doc = db.newDocument();

    Element filesElement = doc.createElement("files");
    doc.appendChild(filesElement);

    for (File file : files) {
        Element fileElement = doc.createElement("file");
        Element nameElement = doc.createElement("name");
        nameElement.setTextContent(file.getName());
        Element typeElement = doc.createElement("type");
        typeElement.setTextContent("xml");
        Element extElement = doc.createElement("extension");
        extElement.setTextContent(".xml");

        fileElement.appendChild(nameElement);
        fileElement.appendChild(typeElement);
        fileElement.appendChild(extElement);
        filesElement.appendChild(fileElement);
    }

    saveXMLDocument("files.xml", doc);
}

public boolean saveXMLDocument(String fileName, Document doc) throws TransformerException {
    File xmlOutputFile = new File(fileName);
    FileOutputStream fos;
    Transformer transformer;
    try {
        fos = new FileOutputStream(xmlOutputFile);
    } catch (FileNotFoundException e) {
        return false;
    }
    TransformerFactory transformerFactory = TransformerFactory.newInstance();

    transformer = transformerFactory.newTransformer();

    DOMSource source = new DOMSource(doc);
    StreamResult result = new StreamResult(fos);

    transformer.transform(source, result);
    return true;
}