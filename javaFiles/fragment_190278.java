public class Graph<T> {
    Map<T, Edge<T>> adjacencyList;
    public Set<T> getVertices() {
        if (adjacencyList.isEmpty()) {
            System.out.println("Error message.\n");
            return null;
        } else {
            return adjacencyList.keySet();
        }
    }
}

Graph<Point> p;
List<Point> points = new LinkedList<>();
points.addAll(p.getVertices());