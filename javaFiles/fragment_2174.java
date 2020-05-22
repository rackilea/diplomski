private int searchIndex(E item, Node<E> node, int index) {
  // break condition: not found at all
  if (node == null) return -1;
  // break condition: found at index
  if (item.equals(node.data)) return index;
  // continue condition: proceed to next node and index
  return searchIndex(item, node.next, index + 1);
}