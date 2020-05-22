@SpringComponent
@UIScope
public class LoginViewPresenter implements LoginViewListener, Serializable {
    private static final long serialVersionUID = 6286518141570430211L;

    private LoginView view;

    public final String randomString;

    public LoginViewPresenter() {
        randomString = Utils.generateRandomString(8);
    }

    @PostConstruct
    public void init() {

    }

    public LoginView getView() {
        return view;
    }

    public void setView(LoginView view) {
        this.view = view;
    }

    @Override
    public void viewInitialized(LoginView v) {
        setView(v);
    }

    @Override
    void eventFired() {
        ...
    }

}