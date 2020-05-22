class Application {

    ...

    Map<String, User> userMap = new HashMap<>();

    public User getUser(String userName) {
        return userMap.get(userName);
    }

    ...
}