public class Node {
  public Node left;
  public Node right;
  public String payload;

  Node(String payload){
    left = null;
    right = null;
    this.payload = payload;
  }

  Node(Node left, Node right, String payload){
    this.left = left;
    this.right = right;
    this.payload = payload;
  }
}