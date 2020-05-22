@Singleton
public class MainDao implements IMainDao
{       
    @Inject
    public MainDao()
    {
    }
}

@Singleton
public class MainBusiness implements IMainBusiness
{
    private IMainDao mainDao;

    @Inject
    public MainBusiness(IMainDao mainDao)
    {
        this.mainDao = mainDao;
    }
}

@Module
interface AppModule {

    @Binds IMainBusiness bindBusiness(MainBusiness impl);

    @Binds IMainDao bindDao(MainDao impl);

}

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent
{
    //  -> no reason not to use constructor injection here as well
    Main getMain(); // provision method
}

public class Main
{   

    private IMainBusiness mainBusiness;

    // favor constructor injection
    @Inject
    public Main(IMainBusiness mainBusiness)
    {
        this.mainBusiness = mainBusiness;
    }

    public static void main(String args[])
    {
        AppComponent component = DaggerAppComponent.builder().build()
        Main main = component.getMain();
        System.out.println(main.mainBusiness.getResource());
    }
}