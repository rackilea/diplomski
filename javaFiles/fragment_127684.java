interface TreeNode<N extends TreeNode<N>> {
  N getLeftChild();
  N getRightChild();
  void setLeftChild(N node);
  void setRightChild(N node);
}