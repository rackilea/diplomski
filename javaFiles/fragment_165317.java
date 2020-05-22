String[] strs = {"swing",     // 0
     "platf",     // 1
     "basic",     // 2
     "metal",     // 3
     "JTree"};    // 4

CheckNode[] nodes = new CheckNode[strs.length];
for (int i=0;i<strs.length;i++) {
  nodes[i] = new CheckNode(strs[i]); 
}
nodes[0].add(nodes[1]);
nodes[1].add(nodes[2]);
nodes[1].add(nodes[3]);
nodes[0].add(nodes[4]);
nodes[3].setSelected(true);
JTree tree = new JTree( nodes[0] );
tree.setCellRenderer(new CheckRenderer());
tree.getSelectionModel().setSelectionMode(
  TreeSelectionModel.SINGLE_TREE_SELECTION
);