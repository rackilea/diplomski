public static List<String> getFirstNames(List<String> names){
    return names.stream()
            .map(x->Arrays.asList(x.split("\\s[A-Za-z]+")))
            .flatMap(Collection::stream)
            .collect(Collectors.toList());
}