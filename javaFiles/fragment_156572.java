public static Map<String, Object> introspect(Object obj) throws Exception {
    Map<String, Object> result = new HashMap<String, Object>();
    BeanInfo info = Introspector.getBeanInfo(obj.getClass());
    for (PropertyDescriptor pd : info.getPropertyDescriptors()) {
        Method reader = pd.getReadMethod();
        if (reader != null)
            result.put(pd.getName(), reader.invoke(obj));
    }
    return result;
}