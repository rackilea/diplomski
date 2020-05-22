public static void main(String[] args) throws Exception {
    Class<?> clazz = Example.class;
    for (Method method : clazz.getDeclaredMethods()) {
        if (!method.getName().startsWith("method")) {
            continue;
        }
        System.out.println("Method '" + method + "' -> " + getRawTypeArgument(method));
    }
}