public static void main(String[] args) {
  Node<E>[] nodes = go_deep(head); //returns the array of nodes
  Node<E> lastNode = nodes[1]; // returns the last Node
  Node<E> prevNode = nodes[0]; //returns the Node before
  Node<E> newNode = new Node<E>();      

  // update newNode with lastNode's values
  newNode.foo = lastNode.foo;
  newNode.bar = lastNode.bar + 7;

  prevNode.next = newNode; //newNode is inserted into the structure - lastNode dies :(
}