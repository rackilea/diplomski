public static void main(String[] args) {

    Graph graph = new Graph();

    //construct vertices 
    Vertex v1 = new Vertex("1"); 
    Vertex v2 = new Vertex("2"); 
    Vertex v3 = new Vertex("3");
    Vertex v4 = new Vertex("4");
    Vertex v5 = new Vertex("5");

    //to make the graph un directed use the same weight 
    //both ways 
    v1.addEdge(new Edge(v2, 1)); //connect v1 v2 
    v2.addEdge(new Edge(v1, 1));   

    v2.addEdge(new Edge(v3, 2)); //connect v2 v3
    v3.addEdge(new Edge(v2, 2));

    v2.addEdge(new Edge(v4, 3)); //connect v2 v4
    v4.addEdge(new Edge(v2, 3));

    v4.addEdge(new Edge(v5, 1)); //connect v4 v5
    v5.addEdge(new Edge(v4, 1));

     graph.addVertex(v1); graph.addVertex(v2); graph.addVertex(v3);
     graph.addVertex(v4); graph.addVertex(v5);  
}