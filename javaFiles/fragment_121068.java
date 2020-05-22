/* Given a binary tree, print its nodes in inorder*/
void printInorder(Node node) 
{ 
    if (node == null) 
        return; 

    /* first recur on left child */
    printInorder(node.left); 

    /* then print the data of node */
    if(!node.isEmpty){
        System.out.print(node.value+ " "); 
    }

    /* now recur on right child */
    printInorder(node.right); 
}