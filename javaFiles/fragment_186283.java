public class MyApplication extends Application {
    private final CoreComponent coreComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        coreComponent = DaggerCoreComponent
                            .coreModule(new CoreModule())
                            .build();
    }

    public static CoreComponent getCoreComponent(Context context) {
        return ((MyApplication) context.getApplicationContext()).coreComponent;
    }
}