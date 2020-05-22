List<Class<?>> list = new LinkedList<Class<?>>();
Class<?> cls = A.class;
while (cls != null) {
    // Call cls.getInterfaces, add result to list
    // ...

    // Go to its parent
    cls = cls.getSuperclass();
}