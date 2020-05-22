protected BeanInfo getBeanInfo(Class<T> entityClass) {
    try {
        return Introspector.getBeanInfo(entityClass);
    }
    catch( IntrospectionException ie ) {
        throw new RuntimeException(ie);
    }
}