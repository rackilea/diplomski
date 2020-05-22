public int position(int val) {
   positionHelper(val, root, 0);
}

public int positionHelper(int val, Node currentNode, int steps) {
   // In-order search checks left node, then current node, then right node
   if(currentNode.getLeftChild() != null) {
       steps = positionHelper(val, currentNode.getLeftChild(), steps++);
   }

   // We found the node or have already moved over the node, return current steps
   if(currentNode.getValue() >= val) {
       return steps;
   }

   // Next Node Index  
   steps++;

   if(currentNode.getRightChild() != null) {
       steps = positionHelper(val, currentNode.getRightChild(), steps++);
   }

   return steps;
}