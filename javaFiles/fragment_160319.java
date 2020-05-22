public class App extends MultiDexApplication implements
    HasActivityInjector,
    HasFragmentInjector {

    @Inject DispatchingAndroidInjector<Activity> activityInjector;
    @Inject DispatchingAndroidInjector<Fragment> fragmentInjector;
    private AppComponent mComponent;

    @Override
    public void onCreate() {
        mComponent = DaggerAppComponent.builder().application(this).build();
        mComponent.inject(this);
    }

    // Dependency Injection
    @Override
    public DispatchingAndroidInjector<Activity> activityInjector() {
        return activityInjector;
    }

    @Override
    public DispatchingAndroidInjector<Fragment> fragmentInjector() {
        return fragmentInjector;
    }
}