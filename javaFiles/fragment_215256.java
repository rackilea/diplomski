@Override
public void onCreate() {
    AppModule appModule = new AppModule(this);
    mMainComponent = DaggerMainComponent.builder().appModule(appModule).build();
    mMainComponent.withReceiversModule().inject(this); // It's works!!! :)
    super.onCreate();  
    // do something
    mFirstUtility.doFistThings(getClass().getSimpleName());
    mSecondUtility.doSecondThings(getClass().getSimpleName());
}