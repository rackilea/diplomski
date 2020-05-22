public class Problem {

  private List<Integer[]> edges;
  private LinkedList<Node> pendingNodes = new LinkedList<>();
  private Map<Integer, Node> nodeMap = new HashMap<>();
  private Set<Integer> visitedNodes = new HashSet<>();

  public Problem(List<Integer[]> edges) {
    this.edges = edges;
  }

  public void run(Integer root) {
    //Initialization
    Node rootNode = new Node(root);
    this.pendingNodes.add(rootNode);
    this.nodeMap.put(root, rootNode);

    while(!pendingNodes.isEmpty()) {
      Node parent = pendingNodes.poll();
      for (Integer[] edge : edges) {
        if(edge[0].equals(parent.getKey())) {
          link(parent, edge[1]);
        } else if (edge[1].equals(parent.getKey())) {
          link(parent, edge[0]);
        }
      }
      visitedNodes.add(parent.getKey());
    }
  }

  public void link(Node parent, Integer child) {
    if(!visitedNodes.contains(child)) {
      //get the corresponding node, create it if not exists
      Node childNode = nodeMap.get(child);
      if (childNode == null) {
        childNode = new Node(child);
        nodeMap.put(child, childNode);
        pendingNodes.add(childNode);
      }

      //Choose between left and right...
      if (parent.getLeft() == null) {
        parent.setLeft(childNode);
      } else {
        parent.setRight(childNode);
      }
    }
  }

  public static void main(String[] args) {

    //Build the input dataset
    List<Integer[]> edges = Arrays.asList(
        new Integer[]{3, 4},
        new Integer[]{3, 0},
        new Integer[]{4, 5},
        new Integer[]{1, 3},
        new Integer[]{2, 4}
    );

    Problem problem = new Problem(edges);
    problem.run(1);

    Map<Integer, Node> nodeMap = problem.nodeMap;
    for (Node node : nodeMap.values()) {
      System.out.println(node);
    }
  }

}