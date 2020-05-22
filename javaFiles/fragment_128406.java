private boolean compareTrees(BinaryTreeNode n1, BinaryTreeNode n2)
{
    if (n1 == null || n2 == null)
        return n1 == n2;  // i.e. both null

    if (n1.getNodeData() != n2.getNodeData())
        return false;

    return compareTrees(n1.left, n2.left) && compareTrees(n1.right, n2.right);
}