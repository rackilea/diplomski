DLinkedNode<E> newNode = new DLinkedNode<E>(item, node.next, node);
if (node.next != null)
   node.next.prev = newNode;
newNode.next = node.next;
node.next = newNode;
newNode.prev = node;