public class UsersCreator {
    public static void createUsers() {
        UsersHolder.addUser(new User(1, "Peter"));
        System.out.println("Created user " + UsersHolder.getUsersMap().get(1).getName());
        UsersHolder.addUser(new User(2, "Paul"));
        System.out.println("Created user " + UsersHolder.getUsersMap().get(2).getName());
    }

    public static void main(String[] args) {
        UsersCreator.createUsers();
        System.out.println("Number of users before notification: " + UsersHolder.getUsersMap().size());
        new UsersNotificator().notifyAllUsersButPeters(UsersHolder.getUsersMap());
        System.out.println("Number of users after notification: " + UsersHolder.getUsersMap().size());
    }
}