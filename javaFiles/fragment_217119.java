public class Dijkstra {

  private static final class DijkstraComparator implements Comparator<Integer> {
    private final int[] distance;

    DijkstraComparator(int[] distance) {
        this.distance = distance;
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return Integer.compare(distance[o1], distance[o2]);
    }
  }

  private Graph graph;
  private int[] distance;
  private boolean[] visited;
  private int[] parents;
  private int startNode;
  private int endNode;

  public Dijkstra(Graph graph, int startNode, int endNode) {
    this.graph = graph;
    distance = new int[graph.getAdjList().length];
    visited = new boolean[graph.getAdjList().length];
    parents = new int[graph.getAdjList().length];
    this.startNode = startNode;
    this.endNode = endNode;
  }

  public void findPath(boolean isUnweighted) {
    if (endNode == startNode) {
        System.out.println("Starting node  " + startNode + "  and target node " + endNode + " are identical.");
        return;
    }

    int[][] graphForPathFinding;
    if (isUnweighted) {
        // set all weights to 1
        graphForPathFinding = convertGraphToUnweighted();
    } else {
        graphForPathFinding = graph.getAdjList();
    }

    // initialize
    for (int i = 0; i < parents.length; i++) {
        parents[i] = Integer.MAX_VALUE;
        visited[i] = false;
        distance[i] = Integer.MAX_VALUE;
    }

    PriorityQueue<Integer> queue = new PriorityQueue<>(1, new DijkstraComparator(distance));
    distance[startNode] = 0;
    queue.add(startNode);

    while (queue.isEmpty() == false) {
        int nextNode = queue.poll();
        visited[nextNode] = true;

        if (nextNode == endNode) {
            printResults();
            return; // target node reached
        }

        int[] neighbors = graph.getNeighbors(nextNode);
        for (int neighbor : neighbors) {
            if (visited[neighbor] == false) {
                // update distance
                int d = distance[nextNode] + graphForPathFinding[nextNode][neighbor];
                if (d < distance[neighbor]) {
                    distance[neighbor] = d;
                    parents[neighbor] = nextNode;

                    // remove neighbors from queue so the value gets updated
                    if (queue.contains(neighbor)) {
                        queue.remove(neighbor);
                    }
                    queue.add(neighbor);
                }
            }
        }
    }
    System.out.println("No path found between " + startNode + " and " + endNode);
  }

  private int[][] convertGraphToUnweighted() {
    int[][] adjMatrix = graph.getAdjList();
    int[][] graphForConverting = new int[adjMatrix.length][adjMatrix.length];
    for (int i = 0; i < adjMatrix.length; i++) {
        int[] adjList = adjMatrix[i];
        for (int j = 0; j < adjList.length; j++) {
            if (adjList[j] != 0) {
                graphForConverting[i][j] = 1;
            } else {
                graphForConverting[i][j] = Integer.MAX_VALUE;
            }
        }
    }
    return graphForConverting;
  }

  private void printResults() {
    int weight = 0;
    int steps = 0;
    System.out.println("Pfad: ");
    for (int node = endNode; node != startNode; steps++) {
        System.out.print(node + "    ");
        weight += graph.getAdjList()[parents[node]][node];
        node = parents[node];
    }
    System.out.println(startNode);
    System.out.println("Number of nodes: " + steps);
    System.out.println("Weight:  " + weight);
  }
}