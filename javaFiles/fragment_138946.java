public Color getColor(E edge) {
    return getColorInternal(graph, edge);
}
private <X> Color getColorInternal(Graph<X, E> g, E e) {
    int degree = g.getInDegree(g.getTarget(e));
    // ...
}