public static void main(String[] args) {
    Tree tree = new Tree();

    // The public concrete types can be used
    Tree.LeafNode  leafNode  = tree.getLeafNode();
    Tree.InnerNode innerNode = tree.getInnerNode();

    // The private interface can not be used from outside:
    //Tree.Node node = tree.getRootNode();

    // This is possible: The class only uses its 
    // own private interface here
    tree.traverseNode(tree.getRootNode());
}