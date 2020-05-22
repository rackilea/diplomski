private JTree createTree(DefaultMutableTreeNode rootNode ) {
        NodeInfor3 info =(NodeInfor3)rootNode.getUserObject();
        //NodeInfor3 node  = new NodeInfor3(info.name, info.getSpecVal());
        DefaultMutableTreeNode newRoot = new DefaultMutableTreeNode(info);
        JTree tree = new JTree(newRoot);
        copyChildren(rootNode, newRoot);
        return tree;
    }

    private void copyChildren(DefaultMutableTreeNode source , DefaultMutableTreeNode target) {

        for (int i = 0; i < source.getChildCount(); i++) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode)source.getChildAt(i);
            NodeInfor3 info =(NodeInfor3)node.getUserObject();
            DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(info);
            target.add(newNode);
            if(node.isLeaf() == false){
                copyChildren(node, newNode);
            }
        }
    }

    private void refreshNodeReg(DefaultMutableTreeNode root) {
        NodeInfor3 node = (NodeInfor3)root.getUserObject();
        nodeReg.put(node.getName(), root);
        for (int i = 0; i < root.getChildCount(); i++) {
            refreshNodeReg((DefaultMutableTreeNode)root.getChildAt(i));
        }
    }