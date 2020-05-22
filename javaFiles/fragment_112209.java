import java.util.HashMap;
public class Test {

    public static enum UserRoles {
        ADMIN, USER;

        private static HashMap<String, UserRoles> roles;
        static {
            roles = new HashMap<>();
            for (UserRoles r : UserRoles.values()) {
                roles.put(r.toString(), r);
            }
        }

        public static UserRoles parse(String s) {
            return roles.get(s);
        }
    }

    public static void main(String... args) {
        System.out.println(UserRoles.parse("ADMIN"));
        System.out.println(UserRoles.parse("FOO"));
    }

}