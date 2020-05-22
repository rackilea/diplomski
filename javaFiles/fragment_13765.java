public static void setProperties(Object bean, Properties properties) throws IllegalAccessException, InvocationTargetException, NoSuchMethodException {
  for (Map.Entry<Object, Object> e : properties.entrySet()) {
    if (e.getKey() instanceof String) {
      BeanUtils.setProperty(bean, (String) e.getKey(), e.getValue());
    }
  }
}