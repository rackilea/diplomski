public boolean isBalanced (TreeNode root) {
    return balancedHeight(root) >= 0;
}

public int balancedHeight (TreeNode root) {
    if (root == null) {
        return 0; // an empty tree is balanced
    }
    int left = balancedHeight(root.left);
    if (left < 0) {
        return -1; // left sub-tree is not balanced, so entire tree is not balanced
    }
    int right = balancedHeight(root.right);
    if (left == right) { // the tree is balanced if both sub-trees are balanced 
                         // and both have same height
        return left + 1;
    } else {
        return -1; // tree is not balanced - either the right sub-tree is not
                   // balanced or the two sub-trees have different heights
    }
}