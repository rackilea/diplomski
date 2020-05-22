NodeList definitionElements = inputDOM.getElementsByTagName("definition");
for (int i = 0; i < definitionElements.getLength(); i++) {
    Element current = (Element) definitionElements.item(i);
    Node term = current.getElementsByTagName("term").item(0);
    if(term != null && term.getNodeType() == Node.ELEMENT_NODE)
        current.setAttribute("XPath", ((Element) term).getTextContent());
}