public static boolean areThereMultiplePaths(final Edge edge, DirectedGraph<Entity, Edge> graph) {
        Transformer<Edge, Integer> transformer = new Transformer<Edge, Integer>() {
            public Integer transform(Edge otherEdge) {
                if (otherEdge.equals(edge))
                    return Integer.MAX_VALUE;
                else
                    return 1;
            }
        };

        DijkstraShortestPath<Entity, Edge> algorithm = new DijkstraShortestPath<Entity, Edge>(graph, transformer);
        Double distance = (Double) algorithm.getDistance(edge.getStartNode(), edge.getEndNode());

        return distance < Integer.MAX_VALUE; 
    }