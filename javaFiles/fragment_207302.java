public void postorder(){inorder(root);} // why is this inorder(root), it should be postorder(root), change it same with preorder.
public void postorder(Node current){
if(current != null){
    postorder(current.left);
    postorder(current.right);
    System.out.print(current.name + " ");

  }
}