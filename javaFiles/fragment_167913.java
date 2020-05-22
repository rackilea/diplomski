public List<UserAction> getUserActionList(Map<String, String> map) {
    return Stream.of("userid", "username", "userrole")
        .map(map::get)
        .filter(s -> !checkForNullEmpty(s))
        .limit(1)
        .map(output -> new UserAction(map, output))
        .collect(Collectors.toList());
}