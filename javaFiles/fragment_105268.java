private List<Node> createChildList(Node parent) {
        List<Node> result = new ArrayList<Node>();
        NodeList children = parent.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            result.addAll(createChildList(children.item(i)));
        }
        return result;
    }