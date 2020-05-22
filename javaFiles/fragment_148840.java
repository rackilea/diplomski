Sensor v1 = // sensor instance
Sensor v2 = // another sensor instance
graph.addVertex(v1);
graph.addVertex(v2);

Connection connection = new Connection(/* ... */);
graph.addEdge(v1, v2, connection);
graph.setEdgeWeight(connection, 10.0);