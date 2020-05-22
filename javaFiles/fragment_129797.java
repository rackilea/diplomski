private static Set<Node> getNodesFollowAllEdges(Node node) {
    Set<Node> nodes = getNodesFollowAllEdges(node, new HashSet<>());
    // remember to remove the original node from the set
    nodes.remove(node);
    return nodes;
}

private static Set<Node> getNodesFollowAllEdges(Node node, Set<Node> visited) {
    if (node.getConnectedNodes().isEmpty()) {
        return visited;
    }

    for (Node n : node.getConnectedNodes()) {
        if (!visited.contains(n)) {
            visited.add(n);
            getNodesFollowAllEdges(n, visited);
        }
    }
    return visited;
}