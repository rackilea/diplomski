public static Map<String, Object> mapProperties(Object bean) throws Exception {
    Map<String, Object> properties = new HashMap<>();
    for (Method method : bean.getClass().getDeclaredMethods()) {
        if (Modifier.isPublic(method.getModifiers())
            && method.getParameterTypes().length == 0
            && method.getReturnType() != void.class
            && method.getName().matches("^(get|is).+")
        ) {
            String name = method.getName().replaceAll("^(get|is)", "");
            name = Character.toLowerCase(name.charAt(0)) + (name.length() > 1 ? name.substring(1) : "");
            Object value = method.invoke(bean);
            properties.put(name, value);
        }
    }
    return properties;
}