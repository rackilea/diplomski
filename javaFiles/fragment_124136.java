DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
Document document = documentBuilder.parse(new File("input.xml"));
NodeList bNodes = document.getElementsByTagName("B");
for(int i = 0; i < bNodes.getLength(); i++) {
    Element bElement = (Element) bNodes.item(i);
    NodeList cNodes = bElement.getElementsByTagName("C");
    // ...
}