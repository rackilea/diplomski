public int getHeight() {
  return getHeight(root, 0);
}

private int getHeight(BSTNode node, int currentHeight) {
  if (node == null) {
    return currentHeight;
  }

  int rightHeight = getHeight(node.getRight(), currentHeight + 1)
  int leftHeight = getHeight(node.getLeft(), currentHeight + 1); 
  return Math.max(rightHeight, leftHeight);
}