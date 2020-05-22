public Class UserArray extends User
public static ArrayList<User> users = new ArrayList<User>(50);

public static void signUser(User u) {
    for(User f: users) {
        if(u.name.equals(f.name)) {
            System.out.println("User already exists");
        }
        else {
            users.add(u);
            System.out.println("User signed");
        }
    }
}