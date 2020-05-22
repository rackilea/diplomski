string rebuild(NodeList nodeList) {
    string result = "";
    for (Node n : nodeList) {
        result += "<" + node.getNodeName() + " ";
        NamedNodeMap aMap = node.getAttributes();
        if (aMap != null) {
            int aMapLength = aMap.getLength();
            for (int i=0; i<aMapLength; ++i) {
                Node a = aMap.item(i);
                result += a.getNodeName() + "=" + a.getValue() + " ";
            }
        }
        NodeList nList = node.getChildNodes();
        if (nList == null) {
            result += "/>";
        } else {
            result += ">";
            result += rebuild(nList);
            result += "</" + node.getNodeName() + ">";
        }
    }
    return result;
}