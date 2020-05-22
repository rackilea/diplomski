public int size() {
  int sum = 1; // Count at least this node

  // Ask every child for its size. If this node is a leaf,
  // then no recursive call happens.
  // Otherwise call the size() method recursively for ervery 
  // child node. The child's size() method may also call its 
  // own childs size() method, adding another level of recursion.
  // But we can be sure that the recursion comes to an end because 
  // at every leaf the simple answer will be 1. 
  for(ArrayTreeNode<E> child: children) {
    sum += child.size();
  }

  // return our calculated size. 
  return sum;
}