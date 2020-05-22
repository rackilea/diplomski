public static void makeTreeData(TreeNode root) {
    if (null == root) {
        throw new IllegalArgumentException("root should not be null.");
    }
    if (root.val > 10) {
        return;
    }
    TreeNode left = new TreeNode(root.val * 2);
    makeTreeData(left);
    TreeNode right = new TreeNode(root.val * 2 + 1);
    makeTreeData(right);

    root.left = left;
    root.right = right;
}

public static void makeTreeData2(TreeNode root) {
    root.right = new TreeNode(2);
    root.right.left = new TreeNode(3);
}