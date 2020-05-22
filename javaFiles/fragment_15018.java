final class Node implements Comparable<Node> {

  private final int x;
  private final int y;

  Node(int x, int y) {
    this.x = x;
    this.y = y;
  }

  @Override public boolean equals(Object other) {
    if (!(other instanceof Node)) {
      return false;
    }
    Node otherNode = (Node) other;
    return x == otherNode.x && y == otherNode.y;
  }

  @Override public int hashCode() {
    return x * 31 + y * 17; // For example...
  }

  @Override public int compareTo(Node other) {
    // As of Java 7, this can be replaced with
    // return x != other.x ? Integer.compare(x, other.x) 
    //     : Integer.compare(y, other.y);

    if (x < other.x || (x == other.x && y < other.y)) {
      return -1;
    }
    return x == other.x && y == other.y ? 0 : 1;
  }
}