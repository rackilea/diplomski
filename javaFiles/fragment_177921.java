Class<?> clazz = ...
Method[] methods = clazz.getMethods();
// processing methods
for (Method method : methods) {
    // processing concrete method
    // for example, getting the name
    String name = method.getName();
}