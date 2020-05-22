@Module
public abstract class UserBindingModule {
    @ContributesAndroidInjector(modules = {DrawerBindingModule.class, AndroidSupportInjectionModule.class})
    abstract DrawerActivity bindDrawerActivity();

    @ContributesAndroidInjector
    abstract SubActivity bindSubActivity();
}