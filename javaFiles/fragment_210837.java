public Node<E>[] go_deep(Node<E> nodeRef) {
  // base case
  // THERE ARE EDGE CASES THAT I'M IGNORING BECAUSE I'M NOT PROGRAMMING FOR YOU!
  if(nodeRef.next.next == NULL) {
    Node<E>[] arr = new Node<E>[2];
    arr[0] = nodeRef; // the "prev" node
    arr[1] = nodeRef.next; // the "last" node
    return arr;
  }

  return go_deep(nodeRef.next);
}