// record expanded nodes to reinstate later; 
TreePath rootPath= new TreePath(objectWeKnowIsAtRoot);

Enumeration<TreePath> expandedPaths = tree.getExpandedDescendants(rootPath);

// record current-selection - it's OK if it's null
TreePath selectedPath = tree.getSelectionPath();


// ******* do stuff that may, and often will, modify our tree content ********


// restore valid expansion paths (some may - correctly - have been removed in modifications)
while (expandedPaths != null && expandedPaths.hasMoreElements())
{
    TreePath path = expandedPaths.nextElement();
    if (isPathValid(path))
    {
        tree.expandPath(path);
    }
}

// restore selected path, if apt
if (isPathValid(selectedPath))
{
    tree.setSelectionPath(selectedPath);
}