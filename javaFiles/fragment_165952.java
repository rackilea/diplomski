public static void invokeMethod(Object obj, Class<?> clazz,
        String methodName, Object... args) {
    Method[] methods = clazz.getMethods();
    try {
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                method.invoke(obj, args);
                break;
            }
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}