@Module
public abstract class DrawerBindingModule {
    @DrawerFragmentScope
    @ContributesAndroidInjector(modules = DrawerFragmentModule.class)
    abstract DrawerFragment provideDrawerFragment();
}