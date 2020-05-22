public static List<String> getChildNames(A node, String... path) {
    Stream<A> s = node.getAs().stream();
    for(String name: path)
        s = s.filter(a -> a.getName().equals(name)).flatMap(a -> a.getAs().stream());
    return s.map(A::getName).collect(Collectors.toList());
}