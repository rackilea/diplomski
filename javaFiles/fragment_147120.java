final class UserConverter implements Converter<String, User> {
    ...
    public User convert(String username) {
        return userService.find(username);
    }

}