//each tree is also a node
public class BinaryTree<T> extends Node<T>{
  private BinaryTree<T> parentNode;
  private BinaryTree<T> leftNode;
  private BinaryTree<T> rightNode;

  public BinaryTree() {

  }
}

public class Node<T> {

  T value;
}