public class Node {
  public String value; //contains "C" or "D" etc
  public List<Node> children = new ArrayList<Node>();
  public Node parent;
  public Node(Node parent){
    this.parent = parent;
  }
  public Node(Node parent, String value){
    this.parent = value;
    this.value = value;
  }
  public boolean equals(Object n){//Nodes are equal if they have the same value
    return value.equals(((Node)n).value);
  }
}