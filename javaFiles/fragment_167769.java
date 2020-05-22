DocNode newElement = document.addElement(...)
 DocNode parentElement = newElement.getParent();
 // walk the tree until you find the TreeNode which represents the DocNode
 BranchTreeNode root = treeModel.getRoot();
 BranchTreeNode parentNode = null;
 forEach (root.child)
     if child.getXMLNode().equals(parentElement)
          parentNode = child;
 // now find the childNode which corresponds to the new element
 forEach (parentNode.child)
    if (parentNode.child.getXMLNode().equals(newElement)
         childNode = child;
 // now notify the treeModel that an insertion has happened
 treeModel.nodesWhereInserted(parentNode, childNode ...)