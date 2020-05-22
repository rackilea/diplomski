public class EdgeImpl implements Edge {
  private Node firstNode;
  private Node secondNode;

  public EdgeImpl(Node firstNode, Node secondNode) {
    this.firstNode = firstNode;
    this.secondNode = secondNode;
  }

  @Override
  public Node getFirstNode() {
    return firstNode;
  }

  @Override
  public Node getSecondNode() {
    return secondNode;
  }
}