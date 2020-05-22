boolean titlePrinted = false;
Element root = doc.getDocumentElement();
NodeList cdNodes = root.getChildNodes();
for (int i = 0; i < cdNodes.getLength(); i++) {
    Node cdNode = cdNodes.item(i);
    if (cdNode.getNodeType() == Node.ELEMENT_NODE) {
        NodeList cdAttrNodes = cdNode.getChildNodes();
        if (!titlePrinted) {
            for (int j = 0; j < cdAttrNodes.getLength(); j++) {
                Node cdAttrNode = cdAttrNodes.item(j);
                // add this if statement
                if (cdAttrNode.getNodeType() == Node.ELEMENT_NODE) {
                    System.out.print(cdAttrNode.getNodeName() + ",");
                }
            }
            System.out.println("");
            titlePrinted = true;
        }
        for (int j = 0; j < cdAttrNodes.getLength(); j++) {
            Node cdAttrNode = cdAttrNodes.item(j);
            if (cdAttrNode.getNodeType() == Node.ELEMENT_NODE) {
                NodeList attrNodes = cdAttrNode.getChildNodes();
                for (int k = 0; k < attrNodes.getLength(); k++) {
                    Node attrNode = attrNodes.item(k);
                    if (attrNode.getNodeType() == Node.TEXT_NODE) {
                        System.out.print(attrNode.getNodeValue() + ",");
                    }
                }
            }
        }
        System.out.println("");
    }
}