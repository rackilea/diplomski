@GetMapping("/getUser")
public User returnUser() {
    User user = new User();
    user.setFirstName("Stack");
    user.setLastName("Overflow");
    UserDto userDto = convertUser(user);
    return userDto;
}

private UserDTO convertUser(User user) {
    UserDTO userDTO = new UserDTO();
    userDTO.setFullName(user.getFirstName() + " " + user.getLastName());
    return userDTO;
}