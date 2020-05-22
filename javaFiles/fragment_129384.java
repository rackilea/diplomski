// in Graph
public Graph deepCopy () {
  Graph g = new Graph();
  g.nodes = new ArrayList<Node>();
  Map<Node, Node> isomorphism = new IdentityHashMap<Node, Node>();
  for (Node n : nodes) { 
    g.nodes.add(n.deepCopy(isomorphism));
  }
  return g;
}

// in Node
public Node deepCopy(Map<Node, Node> isomorphism) {
    Node copy = isomorphism.get(this);
    if (copy == null) {
        copy = new Node();
        isomorphism.put(this, copy);
        for (Node connection: connections) {
            copy.connections.add(connection.deepCopy(isomorphism));
        }
    }
    return copy;
}