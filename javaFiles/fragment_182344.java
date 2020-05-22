public static boolean allEqual(intBTNode root, int target)
{
    return root == null
        || root.data == target
           && allEqual(root.left, target)
           && allEqual(root.right, target);
}