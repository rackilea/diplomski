public int getNumberOfLevels(BST.TreeNode<E> n) {
    if(n == null) return 0;
    int left = getNumberOfLevels(n.left);
    int right = getNumberOfLevels(n.right);
    return 1 + Math.max(left, right);
}