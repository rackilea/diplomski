public static void main(String[] args) throws Exception {
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document doc = builder.parse(new InputSource(new StringReader(xml)));

    XPathFactory xpf = XPathFactory.newInstance();
    XPath xp = xpf.newXPath();
    NodeList nodes = (NodeList)xp.evaluate("//@* | //*[not(*)]", doc, XPathConstants.NODESET);

    System.out.println(nodes.getLength());

    for (int i=0, len=nodes.getLength(); i<len; i++) {
        Node item = nodes.item(i);
        System.out.println(item.getNodeName() + " : " + item.getTextContent());
    }
}