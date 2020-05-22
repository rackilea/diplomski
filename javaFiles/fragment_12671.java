public static void preorder(TreeNode root) {
    if (root == null)
        return;
    else {
        System.out.print(root);
        preorder(root.getLeftPtr());
        preorder(root.getRightPtr());
    }
}