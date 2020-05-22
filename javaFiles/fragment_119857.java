public int exampleSum(){
   // Start with the data we have.
   int sum = this.getData();

   // Then get the data we need (from each child, which can be done recursively).
   if (this.getLeftChild() != null) {
       sum += this.getLeftChild().exampleSum();
   }
   // Do the same for the right node.

   return sum; 
}