private class Node {

  public static final boolean RED = true;
  public static final boolean BLACK = false;

  Key key; // key
  Value val; // associated data
  Node left, right; // subtrees
  int N; // # nodes in this subtree
  boolean color; // color of link from
  // parent to this node
  Node(Key key, Value val, int N, boolean color) {
    this.key = key;
    this.val = val;
    this.N = N;
    this.color = color;
  }
}