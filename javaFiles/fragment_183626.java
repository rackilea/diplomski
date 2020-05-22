public boolean allNodesFull(TreeNode n) {
  if(!n.isFull()) {
    return false;
  }
  for (int i = 0; i < n.getNumChildren(); ++i) {
    if (!allNodesFull(n.getChild(i))) {
      return false;
    }
  }
  return true;
}