private List<UserResponse> getUserResponse(UserRequest request) {
    List<User> Users = userServiceClient.getById();
    List<Types> TypesList = getType(Users);
    return typesList.stream()
            .map(type -> new UserResponse(type.getId(), type.getName(), type.getName(), type.getLinkedTo()))
            .collect(Collectors.toList());
}