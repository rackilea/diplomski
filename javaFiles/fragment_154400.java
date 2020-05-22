class Vertex {
    private final String name;
    private final Set<Edge> edges;
}

class Edge {
    private final Vertex end;
    private final double cost;
}

class Graph {
    private final Set<Vertex> vertices;
}

class Path {
    private final Vertex start;
    private final List<Edge> edges;
}