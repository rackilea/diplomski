private static void insertNodes(
        DefaultTreeModel model,
        DefaultMutableTreeNode parent,
        DefaultMutableTreeNode newNode) {

    parent.add(newNode);
    model.nodesWereInserted(parent, new int[]{parent.getChildCount() - 1});
}