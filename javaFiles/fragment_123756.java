DirectedGraph<Integer, DefaultEdge> graph = new DefaultDirectedGraph<>(DefaultEdge.class);

graph.addVertex(7);
graph.addVertex(4);
graph.addVertex(9);
graph.addVertex(3);
graph.addVertex(2);
graph.addVertex(5);

graph.addEdge(7, 4);
graph.addEdge(7, 9);
graph.addEdge(9, 3);
graph.addEdge(3, 2);
graph.addEdge(3, 5);

List<DefaultEdge> path = DijkstraShortestPath.findPathBetween(graph, 7, 2);
System.out.println(path); // prints [(7 : 9), (9 : 3), (3 : 2)]