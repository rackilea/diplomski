private static TreeNode distribute(TreeNode n, TreeNode left, TreeNode right) {
  if (n instanceof Or) {
    if (left instanceof And) {
      // distribute right over left AND
      return new And(new Or(left.getLeft(), right), 
                     new Or(left.getRight(), right));
    } else if (right instanceof And) {
      // distribute left over right AND
      return new And(new Or(right.getLeft(), left), 
                     new Or(right.getRight(), left));
    }
  }

  // no change
  return treeNode;
}