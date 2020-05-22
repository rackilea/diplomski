for (int temp = 0; temp < nList.getLength(); temp++) {
    Node nNode = nList.item(temp);
    if (nNode.getNodeType() == Node.ELEMENT_NODE) {
        Element eElement = (Element) nNode;

        // iterate through children here.
        NodeList childrenList = eElement.getChildNodes();
        for ( Node aNode : childrenList ) {
               // YOU SHOULD HAVE TEST HERE
        }
        NamedNodeMap attrs = eElement.getAttributes();
        int len = attrs.getLength();
        for (int i = 0; i < len; i++) {
            Attr attr = (Attr) attrs.item(i);
            keyValues.put(attr.getNodeName(), attr.getNodeValue());
        }

    }
}