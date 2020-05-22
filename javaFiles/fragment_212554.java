private Map<Key, Graph> getAllGraphsFromDatabase(Iterable<? extends key> keys)
{
  final List<Graph> lListOfGraph = //resultset got from DB Call

  final Map<Key, Graph> map = new HashMap<Key, Graph>(listOfGraph.size());
  for (final Graph graph : lListOfGraph)
    map.put(graph.getKey(), graph);

  return map;
}