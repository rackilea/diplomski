@Override
public <R extends Object & DefaultEdge, T extends Object & DefaultNode> Optional<R>
                                              createRelationship(EdgeOperations edgeOps) {
    ...
    Function<T, R> f = this.edgeSuppliers.get(edgeOps);
    R relationship = f.apply(this);
    ...
}