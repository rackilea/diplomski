Optional<User> optionalUser = userService.editMyUser(id);

if (optionalUser.isPresent()) {
    User user = optionalUser.get();
    // do whatever you need
} else {
   // means user is null - nothing found for ID
   // act accordingly
}