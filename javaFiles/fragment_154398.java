class CostedPath {
    private final List<String> path = new ArrayList<>();
    private double cost = 0.0;

    public CostedPath(String start) {
        path.add(start);
    }

    public CostedPath addNode(String node, Graph graph) {
        this.cost += graph.getCost(path.get(0), node);
        path.add(0, node);
        return this;
    }
}