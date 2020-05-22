public class MyApp extends Application implements HasActivityInjector{
    @Inject
    DispatchingAndroidInjector<Activity> dispatchingAndroidInjector;

    @Inject
    UserManager mUserManager;

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
        AppComponent component = DaggerAppComponent.builder().application(this)
                .build();
        component.inject(this);
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return mUserManager.activityInjector();
    }
}


public class LoginActivity extends AppCompatActivity {
    Intent mOpenDrawerActivity;
    private ActivityLoginBinding binding;

    @Inject
    UserManager mUserManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        ...
    }

    void openDrawerActivity(){
        mUserManager.logIn();
        mOpenDrawerActivity = new Intent(this, DrawerActivity.class);
        startActivity(mOpenDrawerActivity);
        finish();
    }
}


public class DrawerActivity extends BaseUserActivity implements HasSupportFragmentInjector{
    @Override
    protected void onCreate(Bundle savedInstanceState) {         
        super.onCreate(savedInstanceState);
        ...
    }        

    private void onLogout(){
        logoutUser();
    }  
}


public abstract class BaseUserActivity extends BaseActivity {
    @Inject
    UserManager userManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (!userManager.isLoggedIn()) {
            finishView();
        }
    }

    @Override
    protected void androidInject() {
        AndroidInjection.inject(this);
    }

    protected void logoutUser() {
        userManager.logOut();
        finishView();
    }    
}


public abstract class BaseActivity extends AppCompatActivity implements HasSupportFragmentInjector {
    @Inject
    DispatchingAndroidInjector<Fragment> injector;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        androidInject();
        super.onCreate(savedInstanceState);
    }

    protected void androidInject() {
        AndroidInjection.inject(this);
    }

    public void finishView() {
        startActivity(new Intent(this, LoginActivity.class));
        finish();
    }

    @Override
    public AndroidInjector<Fragment> supportFragmentInjector() {
        return injector;
    }
}