@Entity
@Table(name = "roles")
public class Role extends AbstractPersistable<Long> {

    private static final long serialVersionUID = 1L;

    private String role;

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Role() {
    }

    public Role(String role) {
        this.role = role;
    }

}