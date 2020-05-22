public class MyApplication extends Application {

    @Inject
    CalligraphyManager mCalligraphy;

    @Override
    public void onCreate() {
        super.onCreate();

        mComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        mComponent.inject(this);

        // call the initialization
        mCalligraphy.init();
    }
}