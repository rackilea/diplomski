public class Foo {
    // cache for 1 hour
    @ReadThroughSingleCache(namespace="foo", expiration=3600)
    public Object findById(@ParameterValueKeyProvider int id) {
            return loadFromDatabase(id);
    }
}