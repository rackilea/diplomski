for (int j = 0; j < nodeList.getLength(); j++) {
    if (nodeList.getLength() <= 1) {
        mapUniques.put(xPathExpr, nodeList.item(j).getFirstChild().getNodeValue());
    } else {
        String nodePath = "";
        Node n = nodeList.item(j);
        while(n  != null) {
            int nodenum = 0;
            Node sib = n.getPreviousSibling();
            while(sib != null) {
                nodenum++;
                sib = sib.getPreviousSibling();
            }
            nodePath = n.getNodeName()+"["+nodenum+"]/"+nodePath;
            n = n.getParentNode();
        }
        multiOccurance.put(nodePath,
                 nodeList.item(j).getFirstChild().getNodeValue());
    }
    counter++;
}