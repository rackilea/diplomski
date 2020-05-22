Queue<NodeWithDepth> q = new ArrayDeque<NodeWithDepth>();
q.add(new NodeWithDepth(root, 1));
while (true) {
  NodeWithDepth nwd = q.remove();
  if (hasNoChildren(nwd.node())) return nwd.depth();
  if (nwd.node().q1 != null) q.add(new NodeWithDepth(nwd.node().q1, nwd.depth() + 1));
  if (nwd.node().q2 != null) q.add(new NodeWithDepth(nwd.node().q2, nwd.depth() + 1));
  if (nwd.node().q3 != null) q.add(new NodeWithDepth(nwd.node().q3, nwd.depth() + 1));
  if (nwd.node().q4 != null) q.add(new NodeWithDepth(nwd.node().q4, nwd.depth() + 1));
}