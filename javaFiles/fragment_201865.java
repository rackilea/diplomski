Node root = new Node("", null);
Node a1 = new Node("A1", null);
Node a2 = new Node("A2", null);
root.addChild(a1);
root.addChild(a2);

Node a11 = new Node("A11", x);
Node a12 = new Node("A12", y);
a1.addChild(a11);
a1.addChild(a12);