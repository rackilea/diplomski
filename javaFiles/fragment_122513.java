final MouseListener ml = new MouseAdapter() {
    public void mousePressed(final MouseEvent e) {
        final int selRow = tree.getRowForLocation(e.getX(), e.getY());
        final TreePath selPath = tree.getPathForLocation(e.getX(), e.getY());
        if (selRow != -1) {
            final DefaultMutableTreeNode node = (DefaultMutableTreeNode) selPath.getLastPathComponent();
            if (e.getClickCount() == 1) {
                // Single click
            } else if (e.getClickCount() == 2) {
                // Double click
                ((LeafNodeObject) node.getUserObject()).onDoubleClick();
            }
        }
    }
};