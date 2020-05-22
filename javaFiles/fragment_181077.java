public void addLeft(BinaryTree subtree){
   if(leftChild != null){
      leftChild.addLeft(subtree);
   }

   leftChild = subtree;
}