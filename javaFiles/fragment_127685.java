class TreeNodeWithInt extends TreeNode<TreeNodeWithInt> {
  int value;
  TreeNodeWithInt leftChild;
  TreeNodeWithInt rightChild;
  public TreeNodeWithInt getLeftChild() { return leftChild; }
  public void setLeftChild(TreeNodeWithInt newLeft) { leftChild = newLeft; }
  ...
}