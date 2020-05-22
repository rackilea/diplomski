import java.util.EnumSet;

import static java.util.EnumSet.of;
import static java.util.EnumSet.range;
import static so.User.Permissions.CanBlah1;
import static so.User.Permissions.CanBlah2;
import static so.User.Permissions.CanBlah3;

public class User {
    public enum Permissions {
        CanBlah1,
        CanBlah2,
        CanBlah3
    }

    public static void main(String[] args) throws Exception {
        EnumSet<Permissions> userPerms = of(CanBlah1, CanBlah2);
        System.out.println(userPerms.contains(CanBlah1)); //true
        System.out.println(userPerms.contains(CanBlah2)); //true
        System.out.println(userPerms.contains(CanBlah3)); //false
        System.out.println(userPerms.containsAll(of(CanBlah1, CanBlah3))); //false
        System.out.println(userPerms.containsAll(range(CanBlah1, CanBlah2))); //true
        System.out.println(userPerms.containsAll(range(CanBlah1, CanBlah3))); //false
    }

}