public class UsersHolder {
    private static Map<Integer, User> usersMap = new HashMap<Integer, User>();

    public static void addUser(final User user) {
        usersMap.put(user.getId(), user);
    }

    public static Map<Integer, User> getUsersMap() {
        return usersMap;
        //return Collections.unmodifiableMap(usersMap);
    }
}