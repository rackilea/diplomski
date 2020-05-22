class Graph{

    private Set<Vertex> vertices; //collection of all verices 

    public Graph() {
        vertices = new HashSet<>();
    } 

    List<Vertex> getVertices() {
        return new ArrayList<>(vertices);
    }   

    boolean addVertex(Vertex vertex){
        return vertices.add(vertex);
    }
}