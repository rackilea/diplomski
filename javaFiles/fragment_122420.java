@Override public boolean importData(TransferSupport support) {
  if (!canImport(support)) {
    return false;
  }
  DefaultMutableTreeNode[] nodes = null;
  try {
    Transferable t = support.getTransferable();
      nodes = (DefaultMutableTreeNode[]) t.getTransferData(flavor);
  } catch (UnsupportedFlavorException | IOException ex) {
      ex.printStackTrace();
  }

  JTree.DropLocation dl = (JTree.DropLocation) support.getDropLocation();
  int childIndex = dl.getChildIndex();
  TreePath dest = dl.getPath();
  DefaultMutableTreeNode parent = (DefaultMutableTreeNode) dest.getLastPathComponent();
  JTree tree = (JTree) support.getComponent();
  DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

  int index = childIndex;
  if (childIndex == -1) {
    index = parent.getChildCount();
  }

  for (DefaultMutableTreeNode node: nodes) {
    //BAD: model.insertNodeInto(node, parent, index++);
    //Need to use clone of DefaultMutableTreeNode
    DefaultMutableTreeNode clone = new DefaultMutableTreeNode(node.getUserObject());
    //if !node.isLeaf(): clone = somethingDeepCopyTreeNode(node, clone);
    model.insertNodeInto(clone, parent, index++);
  }
  return true;
}