DefaultMutableTreeNode root = new DefaultMutableTreeNode(filename);
DefaultTreeModel treeModel = new DefaultTreeModel(root);

Enumeration enumeration = properties.keys();  
while (enumeration.hasMoreElements()) {  
    String key = (String) enumeration.nextElement();
    String nodeObj = key+" : "+properties.get(key);
    treeModel.insertNodeInto(new DefaultMutableTreeNode(nodeObj), root, 0);
}

JTree tree = new JTree(treeModel);