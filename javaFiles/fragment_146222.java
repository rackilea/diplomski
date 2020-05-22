//obtain Document somehow, doesn't matter how
DocumentBuilder b = DocumentBuilderFactory.newInstance().newDocumentBuilder();
org.w3c.dom.Document doc = b.parse(new FileInputStream("page.html"));

//Evaluate XPath against Document itself
XPath xPath = XPathFactory.newInstance().newXPath();
NodeList nodes = (NodeList)xPath.evaluate("/html/body/p/div[3]/a",
        doc, XPathConstants.NODESET);
for (int i = 0; i < nodes.getLength(); ++i) {
    Element e = (Element) nodes.item(i);
}