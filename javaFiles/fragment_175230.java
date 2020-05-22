public static Map<String, Object> javaSlangBeanProperties(Object bean) {
    try {
        return Stream.of(Introspector.getBeanInfo(bean.getClass(), Object.class)
                                     .getPropertyDescriptors())
                     .filter(pd -> pd.getReadMethod() != null)
                     .toJavaMap(pd -> {
                         try {
                             return new Tuple2<>(
                                     pd.getName(),
                                     pd.getReadMethod().invoke(bean));
                         } catch (Exception e) {
                             throw new IllegalStateException();
                         }
                     });
    } catch (IntrospectionException e) {
        throw new IllegalStateException();

    }
}