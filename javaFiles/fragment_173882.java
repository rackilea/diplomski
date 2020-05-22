public class MyTreeCellRenderer implements TreeCellRenderer {

    private final DefaultTreeCellRenderer defaultRenderer = new DefaultTreeCellRenderer();
    private final  Icon specialIcon;

    public MyTreeCellRenderer(Icon specialIcon) {
        this.specialIcon = specialIcon;
    }

    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        defaultRenderer.getTreeCellRendererComponent(tree, value, selected, expanded, leaf, row, hasFocus);
        if (needsSpecialIcon(tree, value, selected, expanded, leaf, row, hasFocus)) {
            defaultRenderer.setIcon(specialIcon);
        }
        return defaultRenderer;
    }

    private boolean needsSpecialIcon(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        // check condition for special icon here
        return false;
    }
}