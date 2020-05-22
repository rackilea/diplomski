DefaultMutableTreeNode root = new DefaultMutableTreeNode("~");
DefaultTreeModel model = new DefaultTreeModel(root);

DefaultMutableTreeNode docs = new DefaultMutableTreeNode("Documents");
docs.add(new DefaultMutableTreeNode("text1.txt"));
docs.add(new DefaultMutableTreeNode("text2.txt"));
root.add(docs);

DefaultMutableTreeNode pics = new DefaultMutableTreeNode("Pictures");
pics.add(new DefaultMutableTreeNode("text1.txt"));
root.add(pics);