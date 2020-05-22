class Graph {

  PriorityQueue<Vertex> vertexes;

  public Graph() {
    vertexes = new PriorityQueue<Vertex>(10,new Vertex());
  }

  public Vertex maxDegreeVertex() {
    return vertexes.peek();
  }

  ...

}

class Vertex implements Comparator<Vertex> {
  HashSet<Vertex> edges;

  public Vertex() {
    edges = new HashSet<Vertex>();
  }

  public compare(Vertex v1, Vertex v2) {
    v2.edges.size().compareTo(v1.edges.size());
  }

  ...

}