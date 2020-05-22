public Node implements Comparable<Node> {
   ...
   @Override
   public int compareTo(Node o) {
    return this.priority > o.priority;
   }
}