public static class Counter {
   private int value;
   public Counter(int initialValue) { value = initialValue; }
   public boolean decrement() { value--; return value == 0; }
   public boolean expired() { return value <= 0; }
}

public Node inOrderTraverseTree(Node root, Counter counter){
   if  (root != null && ! counter.expired()) {
       Node left = inOrderTraverseTree(root.leftChild, counter);
       if (left != null) {
            return left;
       } else if (counter.decrement()) {
            return root;
       } else {
            return inOrderTraverseTree(root.rightChild, counter); 
       }
   } else {
       return null;
   }
}