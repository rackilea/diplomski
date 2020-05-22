class Node {

  String name;
  Node parent;

  public Node(String name) {
    this.name = name;
  }

  public Node(String name, Node parent) {
    this.name = name;
    this.parent = parent;
  }

  public String getParentName() {
    return this.parent != null ? this.parent.name : null;
  }

}