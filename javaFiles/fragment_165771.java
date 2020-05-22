protected static DefaultMutableTreeNode findNode(DefaultTreeModel model, String path) {
    DefaultMutableTreeNode node = (DefaultMutableTreeNode) model.getRoot();
    String[] parts = path.split("/");
    if (node.getUserObject().toString().equals(parts[0])) {
         return findNode(node, Arrays.copyOfRange(parts, 1, parts.length));
    }
    return null;
}

protected static DefaultMutableTreeNode findNode(DefaultMutableTreeNode node, String[] path) {
    if (path.length == 0) {
        return node;
    }
    Enumeration<TreeNode> children = node.children();
    while (children.hasMoreElements()) {
        DefaultMutableTreeNode child = (DefaultMutableTreeNode)children.nextElement();
        if (child.getUserObject().toString().equals(path[0])) {
            return findNode(node, Arrays.copyOfRange(path, 1, path.length));
        }
    }
    return null;
}