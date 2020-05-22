for (int j = 0; j < nodeList2.getLength(); j++) {
    org.w3c.dom.Node subNode = nodeList2.item(j);
    NodeList childNodes = subNode.getChildNodes();
    for(int iDx = 0; iDx < childNodes.getLength(); iDx++){
    if(childNodes.item(iDx) instanceof Element){
        Element e = (Element) childNodes.item(iDx);
        System.out.println("RoundTime : "+ e.getFirstChild().getNodeValue());
    }
}