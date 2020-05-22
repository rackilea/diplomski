public static Iterable<Class<?>> getClassHierarchy(Class<?> baseClass) {

    return Traverser.forGraph(
        (SuccessorsFunction<Class<?>>) node -> {
            Class<?> superclass = node.getSuperclass();
            List<Class<?>> interfaces = Arrays.asList(node.getInterfaces());
            return superclass == null ? interfaces
                : Iterables.concat(interfaces, Collections.singleton(superclass));
        }
    ).breadthFirst(baseClass);
}