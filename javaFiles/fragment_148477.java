class Vertex { 

    private String label;
    private Set<Edge> edges; //collection of edges to neighbors 

    public Vertex(String pageObject) {
        this.label = pageObject;
        edges = new HashSet<>();
    }

    String getLabel() {
        return label;
    }

    boolean addEdge(Edge edge){
        return edges.add(edge);
    }

    List<Edge> getEdges() {
        return new ArrayList<>(edges);
    }

    //todo override hashCode()
}