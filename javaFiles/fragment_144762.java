public interface DefaultNode extends Node {
    ...
    public <S extends Object & DefaultNode> Optional<S>
        createRelationship(NodeOperations nodeOps);
    public <R extends Object & DefaultEdge, T extends Object & DefaultNode> Optional<R>
        createRelationship(EdgeOperations edgeOps);
    ...
}