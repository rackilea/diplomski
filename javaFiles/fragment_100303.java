public class UsersNotificator {
    public void notifyAllUsersButPeters(final Map<Integer, User> map) {
        //we don't need peters, so we'll remove them from the list;
        Iterator<Entry<Integer, User>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getValue().getName().equals("Peter")) {
                iterator.remove();
            }
        }
        //now we can notify all from the list;
        notifyUsers(UsersHolder.getUsersMap());
    }

    private void notifyUsers(Map<Integer, User> map) {
        for (final User user : map.values())
        System.out.println("notifyingUsers: " + user.getName());
    }
}