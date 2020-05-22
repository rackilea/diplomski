public static Map<String, Object> guavaBeanProperties(Object bean) {
    Object NULL = new Object();
    try {
        return Maps.transformValues(
                Arrays.stream(
                        Introspector.getBeanInfo(bean.getClass(), Object.class)
                                    .getPropertyDescriptors())
                      .filter(pd -> Objects.nonNull(pd.getReadMethod()))
                      .collect(ImmutableMap::<String, Object>builder,
                               (builder, pd) -> {
                                   try {
                                       Object result = pd.getReadMethod()
                                                         .invoke(bean);
                                       builder.put(pd.getName(),
                                                   firstNonNull(result, NULL));
                                   } catch (Exception e) {
                                       throw propagate(e);
                                   }
                               },
                               (left, right) -> left.putAll(right.build()))
                      .build(), v -> v == NULL ? null : v);
    } catch (IntrospectionException e) {
        throw propagate(e);
    }
}