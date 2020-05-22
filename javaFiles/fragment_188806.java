gremlin> graph = TinkerGraph.open();
==>tinkergraph[vertices:0 edges:0]
gremlin> v1 = graph.addVertex();
gremlin> v2 = graph.addVertex();
gremlin> v3 = graph.addVertex();
gremlin> v4 = graph.addVertex();
gremlin> v5 = graph.addVertex();
gremlin> v6 = graph.addVertex();
gremlin> v1.addEdge("edgeLabel", v4);
gremlin> v2.addEdge("edgeLabel", v5);
gremlin> v3.addEdge("edgeLabel", v6);