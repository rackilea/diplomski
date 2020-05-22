@Override
public void treeNodesChanged(final TreeModelEvent e) {
    System.out.println(System.currentTimeMillis() + ": nodes changed");

    DefaultMutableTreeNode node = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
    if (node == null) {
        return;
    }
    changeSubTreeSelections(node, null);
    tree.treeDidChange();
}