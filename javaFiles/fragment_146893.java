class Node {
   public List<Node> getChildren() { .... }

   public void traverse(Visitor<Node> visitor) {
      // If children
      // go to first child - by traversing the children first.
       for(Node kid: getChildren())
           kid.traverse(visitor);
           // If no children
           //  go to next sibling, - by continuing the loop.

       visitor.visit(this);
       // If no siblings
       // go to parent - by returning and letting the parent be processed
   }
}


interface Vistor<N> {
   public void visit(N n);
}