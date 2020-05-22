@Entity
public class Project2User2Role {
    @EmbeddedId
    private Project2User2RoleId id;

    public User getUser() {
        return this.id.getUser();
    }

    public Project getProject() {
        return this.id.getProject();
    }

    // ...
}