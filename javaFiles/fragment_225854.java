String xml = "<message>HELLO!</message>";
DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
DocumentBuilder db = null;
try {
    db = dbf.newDocumentBuilder();
    InputSource is = new InputSource();
    is.setCharacterStream(new StringReader(xml));
    try {
        Document doc = db.parse(is);
        String message = doc.getDocumentElement().getTextContent();
        System.out.println(message);
    } catch (SAXException e) {
        // handle SAXException
    } catch (IOException e) {
        // handle IOException
    }
} catch (ParserConfigurationException e1) {
    // handle ParserConfigurationException
}