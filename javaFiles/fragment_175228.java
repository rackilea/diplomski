public static Map<String, Object> beanProperties(Object bean) {
  try {
    return Arrays.asList(
         Introspector.getBeanInfo(bean.getClass(), Object.class)
                     .getPropertyDescriptors()
      )
      .stream()
      // filter out properties with setters only
      .filter(pd -> Objects.nonNull(pd.getReadMethod()))
      .collect(Collectors.toMap(
        // bean property name
        PropertyDescriptor::getName,
        pd -> { // invoke method to get value
            try { 
                return pd.getReadMethod().invoke(bean);
            } catch (Exception e) {
                // replace this with better error handling
               return null;
            }
        }));
  } catch (IntrospectionException e) {
    // and this, too
    return Collections.emptyMap();
  }
}