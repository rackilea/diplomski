public List<Vertex> allVertices(Graph g) {    
  final List<Vertex> vertices = new ArrayList<>();
  for (Vertex v = g.first; v != null; v = v.next)
     vertices.add(v);
  return vertices;
}