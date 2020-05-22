import java.security.Permission;
import java.security.Permissions;
import java.security.SecurityPermission;

public class PermissionFactory {
        public static Permission createOneEntity() {
            return new SecurityPermission("entity.create.one");
        }
        public static Permission createManyEntities() {
            return new SecurityPermission("entity.create.many");
        }
        public static Permission deleteEntity(Entity e) {
            return new SecurityPermission("entity.delete." + entyty.getOwnerId());
        }   

        public static Permission deleteMyEntity(User owner) {
            return new SecurityPermission("entity.delete." + user.getId());
        }   
        public static Permission deleteAnyEntity() {
            return new SecurityPermission("entity.delete.*"); // * is a placeholder for 'any'
        }   
    }

public class User {
    private final Permissions permissions  = new Permissions();

    public void addPermission(Permission p) {
        if(p != null) {
            this.permissions.add(p);
        }
    }
    public boolean hasPermission(Permission p){
        return permissions.implies(p);
    }
}