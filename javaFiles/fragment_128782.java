tree.insert(new Node(12));
System.out.println();
tree.inorder(tree.getRoot());
//  Start changes
Node node5 = new Node(5);
tree.insert(node5);
System.out.println();
tree.inorder(tree.getRoot());
//  End changes
tree.insert(new Node(9985));
// -cut some code
//DELETION
System.out.println("DELETION");
tree.delete(node5);
System.out.println();
tree.inorder(tree.getRoot());