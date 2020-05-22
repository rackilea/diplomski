public class SpApplication extends Application {

    @Inject SP sp; // the dependency that should be injected

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        getComponent().inject(this); // this is when the actual injection takes place
    }


    public ApplicationComponent getComponent() {
        if (component == null) {
            // this is the way Dagger components should be instantiated
            component = DaggerApplicationComponent.builder()
                .appModules(new AppModules(this))
                .build();
        }
        return component;
    }
}