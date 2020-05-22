private static int inorderArray(TreeNode root, int[] array, int index) {
    if (root == null) {
        return index;
    }

    index = inorderArray(root.left, array, index);
    array[index++] = root.key;
    index = inorderArray(root.right, array, index);
    return index;
}