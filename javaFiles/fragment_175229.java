public static Map<String, Object> beanProperties(Object bean) {
    try {
        Map<String, Object> map = new HashMap<>();
        Arrays.asList(Introspector.getBeanInfo(bean.getClass(), Object.class)
                                  .getPropertyDescriptors())
              .stream()
              // filter out properties with setters only
              .filter(pd -> Objects.nonNull(pd.getReadMethod()))
              .forEach(pd -> { // invoke method to get value
                  try {
                      Object value = pd.getReadMethod().invoke(bean);
                      if (value != null) {
                          map.put(pd.getName(), value);
                      }
                  } catch (Exception e) {
                      // add proper error handling here
                  }
              });
        return map;
    } catch (IntrospectionException e) {
        // and here, too
        return Collections.emptyMap();
    }
}