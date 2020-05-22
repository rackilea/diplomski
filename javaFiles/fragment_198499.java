private static RootDto toDto(final Tree tree) {
    final List<NodeDto> allNodes = new ArrayList<>();
    for ( final Node node : tree.allNodes ) {
        final NodeDto nodeDto;
        if ( node instanceof Node1 ) {
            final Node1 node1 = (Node1) node;
            nodeDto = new Node1Dto(node1.id, node1.node2.id);
        } else if ( node instanceof Node2 ) {
            final Node2 node2 = (Node2) node;
            nodeDto = new Node2Dto(node2.id);
        } else {
            throw new AssertionError("must never happen: " + node);
        }
        allNodes.add(nodeDto);
    }
    final TreeDto treeDto = new TreeDto(tree.rootNode.id, allNodes);
    return new RootDto(treeDto);
}