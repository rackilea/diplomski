@ManagedBean
@ViewScoped
public class UserEdit {

    private User user;

    @EJB
    private UserService service;

    public String save() {
        service.save(user);
        return "users";
    }

    // Getter+setter.
}