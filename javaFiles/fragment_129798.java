Node a = new Node("A");
Node b = new Node("B");
Node c = new Node("C");
Node d = new Node("D");
Node e = new Node("E");
Node f = new Node("F");
Node g = new Node("G");

a.addConnectedNodes(b, c, d);
b.addConnectedNodes(e, f);
c.addConnectedNodes(a);
e.addConnectedNodes(b);
f.addConnectedNodes(b);
g.addConnectedNodes(f);

Set<Node> friends = getNodesFollowAllEdges(a);
friends.forEach(node -> System.out.println(node.getName()));