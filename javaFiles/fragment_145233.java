public TreeNode removeSubtree(TreeNode root, int value){
    if (root != null && root.val == value) return null;
    removeSubtreeRecursion(root, value);
    return root;
}

public void removeSubtreeRecursion(TreeNode parent, int val) {
    if (parent.left != null && parent.left.val == val) parent.left = null;
    else removeSubtreeRecursion(parent.left, val);
    if (parent.right != null && parent.right.val == val) parent.right = null;
    else removeSubtreeRecursion(parent.right, val); 
}