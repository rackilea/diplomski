public static Map<Integer, List<Cell>> parse(String pathToFile) {
    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
    Document doc = dBuilder.parse(pathToFile);
    Map<Integer, List<Cell>> result = new HashMap<>();
    NodeList dataNodes = doc.getElementsByTagName("data");
    int count = dataNodes.getLength();
    for (int i = 0; i < count; ++i) {
        Node node = dataNodes.item(i);
        if (node.getNodeType() == Node.ELEMENT_NODE) {
            Element element = (Element) node;
            int value = Integer.parseInt(element.getAttribute("value"));
            result.put(value, getCells(element);
        }
    }
    return result;
}

private static List<Cell> getCells(Element dataNode) {
    List<Cell> result = new ArrayList<>();
    NodeList dataNodes = dataNode.getElementsByTagName("cell");
    int count = dataNodes.getLength();
    for (int i = 0; i < count; ++i) {
        // similar to above code
    }
    return result;
}