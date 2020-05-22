public <T> T getMinElement(TreeNode<T> node) {
  if (node == null){
    return null;
  }
  if (node.getLeftChild() == null){
    return node.getData(); // or whatever your method is
  } else{
    return getMinElement(node.getLeftChild());
  }
}