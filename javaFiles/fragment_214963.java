void addNode(Node parent, Node child, List<Node> nodes){
    parent.add(child);
    if(nodes.length > 1){
        nodes.remove(child);
        addNode(child, nodes[0],nodes);
    }
}