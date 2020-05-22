public static List<Person> doFilter(String groupName) {
    return personMap.entrySet().stream()
            .filter(entry -> entry.getKey().equals(groupName))
            .map(entry -> entry.getValue())
            .flatMap(List::stream)
            // as an option to replace the previous two
            // .flatMap(entry -> entry.getValue().stream()) 
            .collect(Collectors.toList());
}