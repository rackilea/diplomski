public static Class mostDerived(Collection<?> objects) {
    Optional<List<Class<?>>> mostDerived =
        objects.stream()
               .map(Util::getHierarchy) // class list for each
               .reduce((l1, l2) -> {
                   l1.retainAll(l2); // get intersecting classes
                   return l1;
               });
    return mostDerived.map(l -> l.get(0)).orElse(null);
}

private static List<Class<?>> getHierarchy(Object l) {
    List<Class<?>> result = new ArrayList<>();
    for (Class<?> clz = l.getClass(); clz != null; clz = clz.getSuperclass()) {
        result.add(clz);
    }
    return result;
}