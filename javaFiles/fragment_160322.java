private static List<Element> getChildren(Node parent) {
    NodeList nl = parent.getChildNodes();
    List<Element> children = new ArrayList<Element>(nl.getLength());
    for (int i = 0; i < nl.getLength(); i++) {
       Node n = nl.item(i);
       if (n instanceof Element)
            children.add((Element) n);
    }
    return children;
}

public static void GetAllXml(
    ArrayList<ArrayList<ArrayList<String>>> ListTree, Node node) {
    ArrayList<ArrayList<String>> child = new ArrayList<ArrayList<String>>();
    ArrayList<String> childOfChild = new ArrayList<String>();

    List<Element> children = getChildren(node);
    // add children node names
    for (Element e : children)
         childOfChild.add(e.getNodeName());

    if (childOfChild.size() > 0) {
        child.add(childOfChild);
        ListTree.add(child);
    }

    // process next level
    for (Element e : children)
        GetAllXml(ListTree, e);
}