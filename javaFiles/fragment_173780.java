public class MyTreeCellRenderer extends DefaultTreeCellRenderer {
    DefaultTreeCellRenderer defaultTreeCellRenderer=new DefaultTreeCellRenderer();

    @Override
    public Component getTreeCellRendererComponent(JTree tree,Object value, boolean sel, boolean expanded, boolean leaf,int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);

        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        String text = (String)node.getUserObject();
        JTextPane textPane = new JTextPane();
        textPane.setContentType("text/html");
        textPane.setText(text);
        return textPane;
    }
}