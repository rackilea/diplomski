final Graph<LengthData> originalGraph = 
  DotGraphIO.getLengthGraphIO().read(Paths.get("path/to/graph.dot"));

final Graph<LengthData> newGraph = new TableGraph<>();
for (final Connection<LengthData> conn : originalGraph.getConnections()) {
  newGraph.addConnection(conn.from(), conn.to());
}