NodeList nodes = doc.getElementsByTagName("result");
for (int i = 0; i < nodes.getLength(); i++) {
    Node node = nodes.item(i);
    doc.renameNode(node, null, "ClientHolder");
    Element element = (Element) node;
    element.setAttribute("xmlns", "http://www.host.com");
    element.setAttribute("xmlns:xsi", "http://www.w3.org/2001/XMLSchema-instance");
    element.setAttribute("xsi:schemaLocation", "http://www.host.com model.xsd");
}