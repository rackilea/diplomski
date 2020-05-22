public static void ShowTree(TreeNode root, TreeNode parent, depth)
{
    if (root == null) return;

    // output 'depth' spaces.
    // The indentation will help show the structure of the tree.        

    // output node value, and parent (if parent not null)

    // Traverse the left node
    ShowTree(root.left, root, depth+1);

    // Traverse the right node
    ShowTree(root.right, root, depth+1);
}