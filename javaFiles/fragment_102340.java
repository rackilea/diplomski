public List<User> getUsersToInvite(List<User> users) {
    return new ArrayList<>(users.stream()
                                .collect(Collectors.toMap(User::getEmail, 
                                                          Function.identity(), 
                                                          (u1, u2) -> u1))
                                .values());
}