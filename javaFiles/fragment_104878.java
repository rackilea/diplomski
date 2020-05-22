private void addStylesheet(Document doc, String cssLocation) {
    Element docElement = doc.getDocumentElement();
    NodeList heads = docElement.getElementsByTagName("head");
    Element head ;
    if (heads.getLength() == 0) {
        head = doc.createElement("head");
        docElement.appendChild(head);
    } else {
        head = (Element) heads.item(0);
    }
    Element link = doc.createElement("link");
    link.setAttribute("rel", "stylesheet");
    link.setAttribute("type", "text/css");
    link.setAttribute("href", cssLocation);
    head.appendChild(link);     
}