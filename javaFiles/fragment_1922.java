public static void main(String[] args) {

    List<User> users = new ArrayList<>();

    users.add(new User(7, "user1", "user1@c.com"));
    users.add(new User(11, "user20", "user20@c.com"));
    users.add(new User(5, "admin20", "admin20@c.com"));
    users.add(new User(10, "user11", "user11@c.com"));
    users.add(new User(6, "admin21", "admin21@c.com"));
    users.add(new User(12, "user21", "user21@c.com"));
    users.add(new User(8, "user2", "user2@c.com"));
    users.add(new User(1, "admin1", "admin1@c.com"));
    users.add(new User(3, "admin10", "admin10@c.com"));
    users.add(new User(2, "admin2", "admin2@c.com"));
    users.add(new User(9, "user10", "user10@c.com"));
    users.add(new User(4, "admin11", "admin11@c.com"));

    for (User item : users) {
        System.out.println(item.getEmail());
    }

    System.out.println("__________________________");

    Collections.sort(users, new FieldComparator(User.class, "email"));

    for (User item : users) {
        System.out.println(item.getEmail());
    }

    System.out.println("__________________________");

    Collections.sort(users, new FieldComparator(User.class, "name"));

    for (User item : users) {
        System.out.println(item.getEmail());
    }

    System.out.println("__________________________");

    Collections.sort(users, new FieldComparator(User.class, "id"));

    for (User item : users) {
        System.out.println(item.getEmail());
    }
}