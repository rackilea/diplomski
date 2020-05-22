@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        AppBindingModule.class 
})
public interface AppComponent extends AndroidInjector<DaggerApplication> {
    @Component.Builder
    interface Builder{
        @BindsInstance Builder application(Application application);

        AppComponent build();
    }

    void inject(MyApp app);

    UserComponent.Builder userBuilder();

    UserManager getUserManager();
}