interface User {}

class UserParser implements Parser<User> {
    @Override
    public User fromString(String s) {
        return new User() {};
    }
}



toList("a.b.c", new UserParser());