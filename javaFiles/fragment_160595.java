boolean removedVertex = false;
while (!removedVertex && graph.getVertexCount() > 0) {
  for (V v : graph.getVertices()) {
    if (graph.getDegree(v) < k) {
      graph.removeVertex(v);
      removedVertex = true;
    }
  }
}
// at this point the graph is either empty or all remaining vertices
// have degree >= k