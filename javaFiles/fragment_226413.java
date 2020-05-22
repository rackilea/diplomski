Node n1 = new Node("n1");
n1.setType(NodeType.START);

Node n2 = new Node("n2");
n2.setType(NodeType.GOAL);

n1.setNeighborNode(n2, 5);