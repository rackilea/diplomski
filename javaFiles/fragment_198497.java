private static Tree createTree() {
    final Tree tree = new Tree();
    tree.rootNode = new Node1("1");
    tree.allNodes = new ArrayList<Node>();
    tree.allNodes.add(new Node1("1", new Node2("2")));
    tree.allNodes.add(new Node2("2"));
    return tree;
}