public static Object getNestedPropertyIfExists(Object bean, String name) {
    try {
        return PropertyUtils.getNestedProperty(bean, name);
    } catch (NestedNullException e) {
      // Do nothing
    }
    return null;
}