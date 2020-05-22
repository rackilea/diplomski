tree.setCellRenderer(new DefaultTreeCellRenderer() {
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean isLeaf, int row, boolean focused) {
        JComponent c = (JComponent) super.getTreeCellRendererComponent(tree, value, selected, expanded, isLeaf, row, focused);
        //setBackgroundSelectionColor(Color.BLUE);
        c.setBackground(selected ? Color.BLUE : tree.getBackground());
        c.setOpaque(true);
        return c;
    }
});