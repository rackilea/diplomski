public Component getTreeCellRendererComponent(JTree tree, Object value,
                                              boolean sel,
                                              boolean expanded,
                                              boolean leaf, int row,
                                              boolean hasFocus) {
   //...
   setText(stringValue);
   //...
   return this;
}