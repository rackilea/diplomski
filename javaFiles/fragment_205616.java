private Edge<T> findEdge(Node<T> node) 
{
    for (Edge edge : edges) {
        if (edge.isBetween(this, node)) {
            return edge;
        }
    }
    return null;
}