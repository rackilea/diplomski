private int getDistance(Vertex node, Vertex target) {
    for (Edge edge : edges) {
        if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
            return edge.getWeight();
        }
    }
    throw new RuntimeException("Should not happen");
}