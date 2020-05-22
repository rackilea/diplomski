@UserScope
@Subcomponent(modules = {
        UserBindingModule.class,
        UserModule.class,
        AndroidSupportInjectionModule.class
})
public interface UserComponent extends AndroidInjector<DaggerApplication> {
    void inject(UserManager userManager);

    @Subcomponent.Builder
    interface Builder{
        UserComponent build();
    }
}