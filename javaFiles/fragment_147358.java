public int leaves() {
  if (children.size() == 0) {
    return 1;  // This is a leaf
  }
  int count = 0;  // No leaf, sum up leaves of children
  for (Node child : children) {
    count += child.leaves();
  }
  return count;
}