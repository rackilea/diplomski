public static List<Vertex> getShortestPathTo(Vertex target) {
    List<Vertex> path = new ArrayList<Vertex>();
    for (Vertex vertex = target; vertex != null; vertex = vertex.previous)
        path.add(vertex);
    Collections.reverse(path);
    return path;
}

public static void main(String[] args) {
    Vertex v0 = new Vertex("Redvile");
    Vertex v1 = new Vertex("Blueville");
    Vertex v2 = new Vertex("Greenville");
    Vertex v3 = new Vertex("Orangeville");
    Vertex v4 = new Vertex("Purpleville");

    v0.adjacencies = new Edge[]{ new Edge(v1, 5),
                                 new Edge(v2, 10),
                                 new Edge(v3, 8) };
    v1.adjacencies = new Edge[]{ new Edge(v0, 5),
                                 new Edge(v2, 3),
                                 new Edge(v4, 7) };
    v2.adjacencies = new Edge[]{ new Edge(v0, 10),
                                 new Edge(v1, 3) };
    v3.adjacencies = new Edge[]{ new Edge(v0, 8),
                                 new Edge(v4, 2) };
    v4.adjacencies = new Edge[]{ new Edge(v1, 7),
                             new Edge(v3, 2) };
    Vertex[] start = { v1, v2, v3, v4 };
    Vertex[] end = {v2};
    Vertex[] all = {v0, v1, v2, v3, v4};

    for (int i = 0; i < start.length; i++){
        for(int j = 0; j < end.length; j++){
            computePaths(start[i]);
            System.out.println("Distance to " + end[j] + ": " + end[j].minDistance);
            List<Vertex> path = getShortestPathTo(end[j]);
            System.out.println("Path: " + path);
        }
        //a new start vertex: reset the graph
        for(Vertex v : all) {
            v.reset();
        }
    }
}