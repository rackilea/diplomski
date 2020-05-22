private int getDistance(Vertex node, Vertex target) {
    Integer weight = null;
    for (Edge edge : edges) {
        if (edge.getSource().equals(node) && edge.getDestination().equals(target)) {
            if (weight == null || edge.getWeight() < weight) {
                weight = edge.getWeight();
            }
        }
    }
    if (weight == null) { 
        throw new RuntimeException("Should not happen");
    }
    return weight;
}