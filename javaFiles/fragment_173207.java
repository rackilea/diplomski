public static final ObjectName OBJECT_NAME = createObjectName();

private static ObjectName createObjectName() {
    try {
        return new ObjectName("foo:type=bar");
    } catch (final SomeException exc) {
        throw new Error(exc);
    }  
}