List<User> users = beans.stream().collect(
    groupingBy(
        MyBean::getUserid,
        groupingBy(
            MyBean::getPermission,
            mapping(MyBean::getYear, toList())
        )
    )
).entrySet().stream()
    .map(u -> new User(
            u.getKey(),
            u.getValue().entrySet().stream()
                .map(p -> new Permission(p.getKey(), p.getValue()))
                .collect(toList())
        )
    ).collect(toList());