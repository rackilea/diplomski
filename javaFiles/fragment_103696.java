return users.stream()
    .filter(user -> id.equals(user.getId()))
    .map(
        user -> (user.getData() != null) 
        ? user.getData() 
        : emptyMap()
    )
    .collect(Collectors.toList())
;