Collector<MyBean, ?, List<Permission>> collectPermissions = collectingAndThen(
    groupingBy(MyBean::getPermission, mapping(MyBean::getYear, toList())),
    t -> t.entrySet().stream()
        .map(e -> new Permission(e.getKey(), e.getValue()))
        .collect(toList())
);

List<User> users = beans.stream()
    .collect(groupingBy(MyBean::getUserid, collectPermissions))
    .entrySet().stream()
    .map(e -> new User(e.getKey(), e.getValue()))
    .collect(toList());