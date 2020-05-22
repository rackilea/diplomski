public void processExpansion(NodeExpandedEvent evt) {

  Object source = evt.getSource();
  if (source instanceof HtmlTreeNode) {
    UITree tree = ((HtmlTreeNode) source).getUITree();
    if (tree == null) {
      return;
    }
    // get the row key i.e. id of the given node.
    Object rowKey = tree.getRowKey();
    // get the model node of this node.
    TreeRowKey key = (TreeRowKey) tree.getRowKey();

    TreeState state = (TreeState) tree.getComponentState();
    if (state.isExpanded(key)) {
      System.out.println(rowKey + " - expanded");
    } else {
      System.out.println(rowKey + " - collapsed");
    }
  }
}