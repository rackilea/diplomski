@Module(subcomponents = UserComponent.class)
public abstract class AppBindingModule {

    @ContributesAndroidInjector(modules = LoginModule.class)
    @LoginScope
    abstract LoginActivity loginActivity();

}