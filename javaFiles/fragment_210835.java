public Node<E> go_deep(Node<E> nodeRef) {
  // base case
  if(nodeRef.next == NULL)
    return nodeRef;

  return go_deep(nodeRef.next);
}