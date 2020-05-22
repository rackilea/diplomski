class BST<E implements Comparable<E>>{
  private Node root;
  //...
  private class Node{ // instances of Node are bound to the instance of BST
    E elem;
    Node left, right;
  }
}