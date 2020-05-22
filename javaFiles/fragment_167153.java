// This is java code.
void inorder(Node root){
    if (root ==null)return;
    inorder(root.leftChild);
    System.out.print(root.ID + "  ");
    inorder(root.rightChild);
}

// verify deletion by printing inorder traversal before and after
public static void main(String[] args) {
    // creating the tree
    Node root = new Node(60);
    root.leftChild = new Node(40);
    root.rightChild = new Node(109);
    root.leftChild.leftChild = new Node(20);
    root.leftChild.rightChild = new Node(49);

    inorder(root); // Printing before deleting
    System.out.println();
    myBinaryTree.root = deleteNode(myBinaryTree.root, 109); // delete the node and collect the new reference of the root.
    inorder(root); // Printing after tree
    System.out.println();
}