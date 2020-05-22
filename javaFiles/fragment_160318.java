@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class, // Important
        ActivityModule.class,
        FragmentModule.class
})

public interface AppComponent extends AndroidInjector<App> {

    void inject(App app);

    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder application(Application application);
        AppComponent build();
    }
}