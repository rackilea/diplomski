public static PropertyDescriptor[] getPropertyDescriptionsIncludingFluentSetters( Class<?> clazz) {
    Map<String,Method> getterMethodMap = new HashMap<String,Method>();
    Map<String,Method> setterMethodMap = new HashMap<String,Method>();
    Set<String> allProperties = new HashSet<String>();
    PropertyDescriptor[] properties = null;
    try {
        Method[] methods = clazz.getMethods();
        for (Method m : methods) {
            String name = m.getName();
            boolean isSetter = m.getParameterTypes().length == 1 && name.length() > 3 && name.substring(0,3).equals("set") && name.charAt(3) >= 'A' && name.charAt(3) <= 'Z';
            boolean isGetter = (!isSetter) && m.getParameterTypes().length == 0 && name.length() > 3 && name.substring(0,3).equals("get") && name.charAt(3) >= 'A' && name.charAt(3) <= 'Z';

            if (isSetter || isGetter) {
                name = name.substring(3);
                name = name.length() > 1
                        ? name.substring(0,1).toLowerCase() + name.substring(1)
                        : name.toLowerCase();

                if (isSetter) {
                    setterMethodMap.put(name, m);
                } else {
                    getterMethodMap.put(name, m);
                }
                allProperties.add(name);
            }
        }

        properties = new PropertyDescriptor[allProperties.size()];
        Iterator<String> iterator = allProperties.iterator();
        for (int i=0; i < allProperties.size(); i++) {
            String propertyName = iterator.next();
            Method readMethod = getterMethodMap.get(propertyName);
            Method writeMethod = setterMethodMap.get(propertyName);
            properties[i] = new PropertyDescriptor(propertyName, readMethod, writeMethod);
        }
    } catch (IntrospectionException e) {
        throw new RuntimeException(e.toString(), e);
    }
    return properties;
}