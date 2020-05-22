String xml = "<message>HELLO!</message>";
DOMParser parser = new DOMParser();
try {
    parser.parse(new InputSource(new java.io.StringReader(xml)));
    Document doc = parser.getDocument();
    String message = doc.getDocumentElement().getTextContent();
    System.out.println(message);
} catch (SAXException e) {
    // handle SAXException 
} catch (IOException e) {
    // handle IOException 
}