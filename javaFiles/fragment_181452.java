//used for grouping them by name, birthday and address
static Function<User, List<Object>> groupingComponent = user ->
Arrays.<Object>asList(user.getName(), user.getBirthday(),user.getAddress());
//grouping method used for grouping them by groupingComponent and frequency of it
private static Map<Object, Long> grouping(final List<User> users) {
    return users.stream()
            .collect(Collectors.groupingBy(groupingComponent, Collectors.counting()));
}
//filtering method used for filtering lists if element is contained more than 1 within a list
private static List<Object> filtering(final Map<Object, Long> map) {
    return map.keySet()
            .stream()
            .filter(key -> map.get(key) < 2)
            .collect(Collectors.toList());
}