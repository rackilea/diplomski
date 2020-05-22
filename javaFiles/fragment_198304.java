interface NodeHandler {
    public void handleNode(Node node);
}

class ModifyTree{
    private void handleNodeAndChildren(NodeHandler nodeHandler, Node node) {
        nodeHandler.handleNode(node);
        for(Node child : node.getChildren()) 
            handleNodeAndChildren(nodeHandler, child);
        }
    }

    public void doActionsOnTree(Tree tree) {
        handleNodeAndChildren(new NodeHandler() { public void handlNode(Node n) {/* code for raction1 goes here*/}}, tree.getRoot());
        handleNodeAndChildren(new NodeHandler() { public void handlNode(Node n) {/* code for raction2 goes here*/}}, tree.getRoot());
    }
}