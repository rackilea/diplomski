public <T> void set (NodeStatus nodeStatus, 
                     byte [] value, 
                     BiConsumer<NodeStatus,T> setter, 
                     Function<byte[],T> transformer) {
    T transformedValue = transformer.apply(value);
    setter.accept(nodeStatus, transformedValue);
}