public static Object min(TreeNode t){
    TreeNode min = t;
    if(t == null){
        return min;
    }
    final TreeNode left = t.getLeft();
    final TreeNode right = t.getRight();

    if (left == null && right == null) 
        return min;

    if(left != null && left.compareTo(t) <= 0) {
        min = (TreeNode) min(left);
    if(min != null && right != null && right.compareTo(t) > 0){ // not sure about this 
        min = (TreeNode) min(right);
    }
    return min;
}