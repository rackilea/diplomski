public static Element getElementByAttributeValue(Node rootElement, String attributeValue) {

    if (rootElement != null && rootElement.hasChildNodes()) {
        NodeList nodeList = rootElement.getChildNodes();

        for (int i = 0; i < nodeList.getLength(); i++) {
            Node subNode = nodeList.item(i);

            if (subNode.hasAttributes()) {
                NamedNodeMap nnm = subNode.getAttributes();

                for (int j = 0; j < nnm.getLength(); j++) {
                    Node attrNode = nnm.item(j);

                    if (attrNode.getNodeType == Node.ATTRIBUTE_NODE) {
                        Attr attribute = (Attr) attrNode;

                        if (attributeValue.equals(attribute.getValue()) {
                            return (Element)subNode;
                        } else {
                            return getElementByAttributeValue(subNode, attributeValue);
                        }
                    }
                }               
            }
        }
    }

    return null;
}