public static boolean isFull(TreeNode<Integer>  root)
// pre: root of tree, 0 or more nodes
// post: returns true if the input tree is a full tree; false otherwise
{

    if (root!=null)
    {
        if(root.getRight() == null && root.getLeft() == null)
        {
             return true;
        }
        if ((root.getRight() != null && root.getLeft() != null))
        {
            return isFull(root.getLeft())&&isFull(root.getLeft());
        }
    }
    return false;
}