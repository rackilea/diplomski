public DefaultMutableTreeNode searchNode(String nodeStr) {
    Enumeration e = root.breadthFirstEnumeration();
    while (e.hasMoreElements()) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
        if (node.getUserObject().toString().toLowerCase().startsWith(nodeStr.toLowerCase())) {
            return node;
        }
    }
    return null;
}