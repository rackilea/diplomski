tree.setCellRenderer(new DefaultTreeCellRenderer() {
  @Override
  public Component getTreeCellRendererComponent(JTree tree, Object value, boolean sel, boolean expanded,
                                                boolean leaf, int row, boolean hasFocus) {
    JLabel label = (JLabel)super.getTreeCellRendererComponent(tree, value, sel, expanded, leaf, row, hasFocus);
    YourNode node = (YourNode)value;
    if (node.isFlagged())
      label.setForeground(Color.RED);

    return label;
  }
});