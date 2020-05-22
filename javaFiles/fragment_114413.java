public void preOrderTraversal(BinaryTree root){
    if(root == null) return;

    System.out.println(root);
    preOrderTraversal(root.getLeft());
    preOrderTraversal(root.getRight());
}