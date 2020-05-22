@ManagedBean
@RequestScoped
public class Login {

    @ManagedProperty("#{userSession}")
    private UserSession userSession;

    public String login() {
        // ...

        if (user != null) {
            userSession.setUser(user);
        }

        // ...
    }

}