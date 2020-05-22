public Map<Privilege, List<User>> groupByPrivileges(List<User> users) {
    return users.stream()
            .flatMap(user -> user.getPrivileges().stream()
                    .map(privilege -> new AbstractMap.SimpleEntry<>(privilege, user)))
            .collect(Collectors.groupingBy(Map.Entry::getKey,
                    Collectors.mapping(Map.Entry::getValue, Collectors.toList())));
}