public class GraphEdgeList<V, E> implements Graph<V, E> {
    private Map<V, Vertex<V>> vertices;

    public GraphEdgeList() {
        this.vertices = new HashMap<>();
    }

    public GraphEdgeList(GraphEdgeList graph) {
         this.vertices = new HashMap<>();
         this.vertices.putAll(graph.getVertices());
    }

    @Override
    public void insertVertex(V vElement) {
        this.vertices.put(vElement, null);
    }

    public Map<V, Vertex<V>> getVertices() {
        return vertices;
    }

    public void setVertices(Map<V, Vertex<V>> vertices) {
        this.vertices = vertices;
    }

    @Override
    public Iterable<Vertex<V>> vertices() {
        return this.vertices.values();
    }

    @Override
    public String toString() {
        return "GraphEdgeList [vertices=" + vertices + "]";
    } 
}