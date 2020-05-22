return users.stream()
    .filter(user -> id.equals(user.getId()))
    .map(
        user -> Optional.ofNullable(
            user.getData()
        ).orElseGet(
            () -> emptyMap()
        )
    )
    .collect(Collectors.toList())
;