// if you have two-way references
public static void main(String[] args) {
  Node<E> lastNode = go_deep(head); //returns the last Node
  Node<E> prevNode = lastNode.prev; //returns the Node before
  Node<E> newNode = new Node<E>();      

  // update newNode with lastNode's values
  newNode.foo = lastNode.foo;
  newNode.bar = lastNode.bar + 7;

  prevNode.next = newNode; //newNode is inserted into the structure - lastNode dies :(
}