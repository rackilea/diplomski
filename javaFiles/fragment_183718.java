users.stream()
    .filter(
        User.STATE.equals("NY")
        .or(User.STATE.equals("NJ"))
        .or(User.STATE.equals("PA"))
    )
    .collect(Collectors.toList());