@Singleton
public class UserManager implements HasActivityInjector {
    private final UserComponent.Builder userComponentBuilder;
    @Inject
    DispatchingAndroidInjector<Activity> activityInjector;

    private UserComponent userComponent;

    @Inject
    public UserManager(UserComponent.Builder builder) {
        this.userComponentBuilder = builder;
    }

    public void logIn(){
        createUserSession();
    }

    private void createUserSession() {
        userComponent = userComponentBuilder.build();
        userComponent.inject(this);
    }

    public boolean isLoggedIn() {
        return userComponent != null;
    }

    public void logOut() {
        userComponent = null;
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }
}