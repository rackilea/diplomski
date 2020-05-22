/**
 * Returns the resource reference for icon of specified tree node.
 *
 * @param node
 *            The node
 * @return The package resource reference
 */
protected ResourceReference getNodeIcon(TreeNode node)
{
    if (node.isLeaf() == true)
    {
        return getItem();
    }
    else
    {
        if (isNodeExpanded(node))
        {
            return getFolderOpen();
        }
        else
        {
            return getFolderClosed();
        }
    }
}