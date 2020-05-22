public Object remove(Comparable theKey) {
  Object[] result = new Object[1];
  rootPtr = remove(theKey, rootPtr, result);   // fix for deletion from a one-node tree
  return result[0];
}

public Node remove(Comparable theKey, Node node, Object[] result) {
  if(node == null) {
    return node;
  }
  int diff = theKey.compareTo(node.key);
  if (diff < 0) {
    node.leftChild = remove(theKey, node.leftChild, result);
  } else if (diff > 0) {
    node.rightChild = remove(theKey, node.rightChild, result);
  } else {
    result[0] = node.key;
    if (node.rightChild == null) {
      node = node.leftChild;
    } else if (node.leftChild == null) {
      node = node.rightChild;
    } else {
      Node foundNode = findMin(node.rightChild);
      node.key = foundNode.key;
      node.data = foundNode.data;
      node.rightChild = remove(node.key, node.rightChild, new Object[1]);
    }
    numNodes--;
  }
  return node;
}