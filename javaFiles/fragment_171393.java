Tree node4 = new Tree("Node 4", null, null);
Tree node5 = new Tree("Node 5", null, null);
Tree node2 = new Tree("Node 2", node4, node5);
Tree node6 = new Tree("Node 6", null, null);
Tree node7 = new Tree("Node 7", null, null);
Tree node3 = new Tree("Node 3", node6, node7);
Tree root  = new Tree("Root", node2, node3);