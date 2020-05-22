public static void demonstrating(DefaultNode n, NodeOperations o) {
    abstract class FooBar implements DefaultNode {}
    Optional<FooBar> opt = n.createRelationship(o);
    if(opt.isPresent()) {
        FooBar fb = opt.get();
    }
}