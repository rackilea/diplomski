DefaultMutableTreeNode root = new DefaultMutableTreeNode("Contacts"); // root node

DefaultMutableTreeNode contact1 = new DefaultMutableTreeNode("Contact # 1"); // level 1 node
DefaultMutableTreeNode nickName1 = new DefaultMutableTreeNode("drocktapiff"); // level 2 (leaf) node
contact1.add(nickName1); 

DefaultMutableTreeNode contact2 = new DefaultMutableTreeNode("Contact # 2");
DefaultMutableTreeNode nickName2 = new DefaultMutableTreeNode("dic19");        
contact2.add(nickName2);

root.add(contact1);
root.add(contact2);

DefaultTreeModel model = new DefaultTreeModel(root);
JTree tree = new JTree(model);