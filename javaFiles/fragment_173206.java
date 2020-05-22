public static final ObjectName OBJECT_NAME = createObjectName("foo:type=bar");

private static ObjectName createObjectName(final String name) {
    try {
        return new ObjectName(name);
    } catch (final SomeException exc) {
        throw new Error(exc);
    }  
}