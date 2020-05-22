graphs.stream()
    .map(AbstractBaseGraph::edgeSet)
    .flatMap(Collection::stream)
    .collect(groupingBy(
            edge -> Arrays.asList(
                graph.getEdgeSource(edge), 
                graph.getEdgeTarget(edge)
            ),
            counting()
    ))
    .forEach((nodes, count) -> 
        graph.setEdgeWeight(graph.addEdge(nodes.get(0), nodes.get(1)), count/strains)
    );