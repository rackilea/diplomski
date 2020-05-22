SemanticGraph sg = ....
for (SemanticGraphEdge edge : sg.getEdgesIterable()) {
  int headIndex = edge.getGovernor().index();
  int depIndex = edge.getDependent().index();
  int weight = ... // Not sure what "edge weight" you want here.
  System.out.printf("%d %d %d%n", headIndex, depIndex, weight);
}