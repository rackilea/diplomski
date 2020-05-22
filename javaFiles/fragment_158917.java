void displayPreOrder(TreeNode node)
{
    if(node != null)
    {
        // visit the root first for pre-order
        System.out.println(node.value);
        for (TreeNode child : node.children()) {
            displayPreorder(child)
        }
    }
}