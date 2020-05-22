public static void stringToDom(String xmlSource) 
        throws SAXException, ParserConfigurationException, IOException {
    // Parse the given input
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document doc = builder.parse(new InputSource(new StringReader(xmlSource)));

    // Write the parsed document to an xml file
    TransformerFactory transformerFactory = TransformerFactory.newInstance();
    Transformer transformer = transformerFactory.newTransformer();
    DOMSource source = new DOMSource(doc);

    StreamResult result =  new StreamResult(new File("my-file.xml"));
    transformer.transform(source, result);
}