// change node/user object
 DefaultMutableTreeNode current = (DefaultMutableTreeNode) 
          Global.previousTreePath.getLastPathComponent();
 NodePro npt = (NodePro) current.getUserObject();
 npt.setNodeancestors("activated");
 // notify model
 JTree tree = (JTree) e.getSource();
 ((DefaultTreeModel) tree.getModel()).nodeChanged(current);