class TreeNodeWithInt extends TreeNode {
  int value;
  TreeNodeWithInt leftChild;
  TreeNodeWithInt rightChild;

  public void setLeftChild(TreeNode node) {
    // note the dangerous cast!
    leftChild = (TreeNodeWithInt) node;
  }
}