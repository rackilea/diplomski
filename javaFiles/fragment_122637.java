public enum Injector {
    INSTANCE;

    private AppComponent appComponent;

    static {
        INSTANCE.appComponent = DaggerAppComponent.create();
    }

    public getAppComponent() {
        return appComponent;
    }
}