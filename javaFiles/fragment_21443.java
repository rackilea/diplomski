public class NodeList {
  private ArrayList<Node> nodeList = new ArrayList<Node>();
  private int currentNodeIndex = 0;

  public void add(Node node) {
    nodeList.add(node);
  }
  // Node is private/read-only - currentNode should only be set by internal operations
  public Node getCurrentNode() { 
    return nodeList.get(currentNodeIndex);
  }

  // moving back and forth
  public Node moveAhead(int count) { 
    currentNodeIndex += count;
    return nodeList.get(currentNodeIndex);
  }
  public Node moveBack(int count) { 
    currentNodeIndex -= count;
    return nodeList.get(currentNodeIndex);
  } 

  // peeking back and forth
  public Node peekAhead(int count) {
    return nodeList.get(currentNodeIndex + count);
  }
  public Node peekBack(int count) {
      return nodeList.get(currentNodeIndex - count);
  }

  public void print() {
    for (int i=0; i<nodeList.size(); i++) {
      System.out.print(nodeList.get(i).getToken());
    }
    System.out.println("");
  }
}