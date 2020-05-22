public List<Node> makeThisManyNodes(int count) {
    List<Node> nodes = new ArrayList<Node>();
    for (int i=0; i<count; i++) {
        nodes.add(new Node());
    }
    return nodes;
}