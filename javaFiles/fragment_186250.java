public static List<String> getChildNames(A node, String... pathPatterns) {
    Stream<A> s = node.getAs().stream();
    for(String namePattern: pathPatterns) {
        Pattern compiledPattern = Pattern.compile(namePattern);
        s = s.filter( a -> compiledPattern.matcher(a.getName()).find())
             .flatMap(a -> a.getAs().stream());
    }
    return s.map(A::getName).collect(Collectors.toList());
}