@ManagedBean
@RequestScoped
public class Profile {

    @ManagedProperty(value="#{user}") // #{user} is the managed bean name
    private User user;

    @PostConstruct
    public void init() {
        // User is available here for the case you'd like to work with it
        // directly after bean's construction.
    }

    public String save() {
        // User is available here as well, during action methods.
        userDAO.save(user);
    }

    // +getter +setter

}