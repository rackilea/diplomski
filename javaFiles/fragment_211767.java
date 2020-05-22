private boolean containsMatchingParent(DefaultMutableTreeNode node) 
{
    DefaultMutableTreeNode current = node;
    while (current != null)
    {
        if (matchesFilter(current))
        {
            return true;
        }
        current = (DefaultMutableTreeNode) current.getParent();
    }
    return false;
}