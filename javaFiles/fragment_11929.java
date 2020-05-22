private class FileTreeCellRenderer extends DefaultTreeCellRenderer {
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        Color nodeColor = Color.BLACK;

        if (value instanceof FileNode){
            FileNode fn = (FileNode)value;
            if (!fn.isFolder) {
                if (fn.CheckedOut) {
                    nodeColor = Color.RED;
                }
                else {
                    nodeColor = new Color(0,100,0);
                }
            }
        }

        setForeground(nodeColor);
        return this;
    }
}