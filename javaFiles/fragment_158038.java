public String peel(String xmlString) {
    StringWriter writer = new StringWriter();
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    try {
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.parse(new InputSource(new StringReader(
                xmlString)));
        NodeList nodes = document.getDocumentElement().getChildNodes();
        for (int i = 0; i < nodes.getLength(); i++) {
            Node n = nodes.item(i);
            Document d = builder.newDocument();
            Node newNode = d.importNode(n, true);
            d.insertBefore(newNode, null);
            writeOutDOM(d, writer);
        }
    } catch (ParserConfigurationException e) {
        e.printStackTrace();
    } catch (SAXException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } catch (TransformerFactoryConfigurationError e) {
        e.printStackTrace();
    } catch (TransformerException e) {
        e.printStackTrace();
    }
    return writer.toString();
}

protected void writeOutDOM(Document doc, Writer writer) 
     throws TransformerFactoryConfigurationError, TransformerException {
    Result result = new StreamResult(writer);
    DOMSource domSource = new DOMSource(doc);
    Transformer transformer = TransformerFactory.newInstance()
            .newTransformer();
    transformer.setOutputProperty("omit-xml-declaration", "yes");
    transformer.transform(domSource, result);
}