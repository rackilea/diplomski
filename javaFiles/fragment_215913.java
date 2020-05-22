public static Map<String, Object> mapProperties(Object bean) throws Exception {
    Map<String, Object> properties = new HashMap<>();
    for (PropertyDescriptor property : Introspector.getBeanInfo(bean.getClass()).getPropertyDescriptors()) {
        String name = property.getName();
        Object value = property.getReadMethod().invoke(bean);
        properties.put(name, value);
    }
    return properties;
}