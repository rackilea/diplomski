public static void main(String[] args) throws ParserConfigurationException,
        SAXException, IOException, TransformerConfigurationException, TransformerException {

    DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
    DocumentBuilder db = dbf.newDocumentBuilder();
    db.setEntityResolver(new CatalogResolver());

    File src = new File("src/article.xml");
    Document doc = db.parse(src);

    // Here, we execute the transformation
    // Use a Transformer for output
    File stylesheet = new File("src/aticle.xsl");
    TransformerFactory tFactory = TransformerFactory.newInstance();
    StreamSource stylesource = new StreamSource(stylesheet);
    Transformer transformer = tFactory.newTransformer(stylesource);

    DOMSource source = new DOMSource(document);
    StreamResult result = new StreamResult(System.out);
    transformer.transform(source, result);
}