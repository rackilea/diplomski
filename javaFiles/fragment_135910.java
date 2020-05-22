/**
 * Returns the public static methods of a class or interface,
 *   including those declared in super classes and interfaces.
 */
public static List<Method> getStaticMethods(Class<?> clazz) {
    List<Method> methods = new ArrayList<Method>();
    for (Method method : clazz.getMethods()) {
        if (Modifier.isStatic(method.getModifiers())) {
            methods.add(method);
        }
    }
    return Collections.unmodifiableList(methods);
}