try {
    final BeanInfo beanInfo = Introspector.getBeanInfo(entityClass);
    // rest of constructor here (about 50 lines)
}
catch( IntrospectionException ie ) {
    throw new RuntimeException(ie);
}