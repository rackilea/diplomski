@Module
    public class ActivityModule {

    private final Activity activity;

    public ActivityModule(Activity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    MainView provideMainView() {
        return (MainView) activity;
    }

    @Provides
    SignInView provideSignInView() {
        return (SignInView) activity;
    }
    }