expFail.addActionListener(new ActionListener() {
@Override
public void actionPerformed(ActionEvent e) {
    //Exand the root node 
    jTree1.expandRow(0);        
    //Getting the jtree row from the root containing my red and green leaf node
    DefaultMutableTreeNode dirNode = (DefaultMutableTreeNode) jTree1.getPathForRow(2).getLastPathComponent();
    Enumeration enumDir = dirNode.preorderEnumeration();
    while (enumDir.hasMoreElements()) {
        //Walking through all nodes of dirNode
        DefaultMutableTreeNode enumDirNode = (DefaultMutableTreeNode) enumDir.nextElement();
        //If node is leaf and is red (returned by isFailed()) expand to the previous node of this leaf node
        if (enumDirNode.isLeaf() && !((LeafNodeObject) enumDirNode.getUserObject()).isFailed()) {
            jTree1.expandPath(new javax.swing.tree.TreePath(enumDirNode.getPreviousNode().getPath()));
        }
    }
}