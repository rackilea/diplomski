public void addLeft(BinaryTree subtree){
   if (subtree.value < value)
   {
      int tmp = value;
      value = subtree.value;
      subtree.value = tmp;
   }

   if(leftChild != null){
      leftChild.addLeft(subtree);
   }

   leftChild = subtree;
}