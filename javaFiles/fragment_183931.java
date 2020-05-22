@ManagedBean
@RequestScoped
public class Q16433250Bean {

    private List<Role> userRoles = new ArrayList<Role>();//getter + setter
    private List<Role> userRoles2 = new ArrayList<Role>();//getter + setter
    private List<Role> userRoles3 = new ArrayList<Role>();//getter + setter
    private Role[] userRoles4;//getter + setter

    public enum Role {

        ADMIN("Admin"),
        SUPER_USER("Super user"),
        USER("User");
        private final String name;

        private Role(String name) {
            this.name = name;
        }

        public String getName() {
            return this.name;
        }
    }

    public Role[] getAllRoles() {
        return Role.values();
    }

    public String action() {
        return null;
    }

}