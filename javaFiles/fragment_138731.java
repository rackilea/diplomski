@SuppressWarnings("serial")
@UIScope
@SpringView(name = LoginView.NAME)
public class LoginView extends VerticalLayout implements View {
    public static final String NAME = "LoginView";

    @Autowired
    private transient Collection<LoginViewListener> loginViewListeners;

    @PostConstruct
    private void init() {
        ...
        Button b = new Button("click me");
        b.addClickListener(e -> loginViewListeners.forEach(l -> l.eventFired()));
        addComponent(b);
        ...
        loginViewListeners.forEach(listener -> listener.viewInitialized(this));
    }

    @Override
    public void enter(ViewChangeEvent event)
    {
    }

    public interface LoginViewListener {

        void viewInitialized(LoginView view);


        void eventFired();

    }

}