private DefaultMutableTreeNode cloneRoot() {
    DefaultMutableTreeNode updatableRoot = new DefaultMutableTreeNode("Root");
    for (int i = 0; i < root.getChildCount(); i++) {
        DefaultMutableTreeNode parent = new DefaultMutableTreeNode(root.getChildAt(i));
        updatableRoot.add(parent);
        Enumeration<DefaultMutableTreeNode> children = root.getChildAt(i).children();
        while (children.hasMoreElements()) {
            parent.add(new DefaultMutableTreeNode(children.nextElement()));
        }
    }
    return updatableRoot;
}