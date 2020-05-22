for (int j = 0; j < nodeList.getLength(); j++) {
    if (nodeList.getLength() <= 1) {
        mapUniques.put(xPathExpr, nodeList.item(j).getFirstChild().getNodeValue());
    } else {
        String old = multiOccurance.get(xPathExpr);
        if (old == null) {
            old = "";
        }
        multiOccurance.put(xPathExpr,
                old + " "
                + nodeList.item(j).getFirstChild().getNodeValue());
    }
    counter++;
}