// Adds a node to a JTree providing the name of the parent node that the new node
// belongs to.
private void addNodeToTree(Object newObject, String category, JTree tree) {
    DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
    DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode)treeModel.getRoot();

    // BreadFirst means it searches by top nodes first. It'll start with the root node,
    // then iterate thru the children of the root node and so on.
    Enumeration en = rootNode.breadthFirstEnumeration();

    while ( en.hasMoreElements() ) {
        DefaultMutableTreeNode categoryNode = (DefaultMutableTreeNode)en.nextElement();
        // Get the user defined object.
        Object categoryObject = categoryNode.getUserObject();

        // Check if node matches the category that the new node belongs to and if it does, then
        // add the new node in this category node.
        if ( categoryObject.toString().equals(category) ) {
            // Create a new node.
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(newObject);
            // Use the tree model to insert the new node. This will take care of the UI updates.
            treeModel.insertNodeInto(newNode, categoryNode, categoryNode.getChildCount());
            // Exit out of the loop.
            break;
        }
    }
}

// Iterates thru all the nodes in the JTree and removes the node that
// matches the string node_name.
private void removeNodeFromTree(String node_name, JTree tree) {
    DefaultTreeModel treeModel = (DefaultTreeModel)tree.getModel();
    DefaultMutableTreeNode rootNode = (DefaultMutableTreeNode)treeModel.getRoot();

    // DepthFirst means it provides the very last child nodes and work its way up to the root node.
    Enumeration en = rootNode.depthFirstEnumeration();

    while ( en.hasMoreElements() ) {
        // Get a reference to a node in the tree to see if it is the target node.
        DefaultMutableTreeNode targetNode = (DefaultMutableTreeNode)en.nextElement();
        // Get the virtual component object of the target node.
        Object objectTargetNode = targetNode.getUserObject();

        // If the target node matches the node_name string, then remove the node using
        // the tree model to perform the removal.
        if ( objectTargetNode.toString().equals(node_name) ) {
            treeModel.removeNodeFromParent(targetNode);
            // Exit out of the loop.
            break;
        }
    }
}