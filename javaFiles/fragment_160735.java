// connect to previous and next node
Chunk<E> one = node, two = newChunk, three = node.next;
one.next = two;
two.prev = one;
two.next = three;
if (three != null)
  three.prev = two;