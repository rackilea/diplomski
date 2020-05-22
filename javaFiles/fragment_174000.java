@ApplicationPath( "/rest" )
public class SampleApplication extends Application
{

    private static final Set< Object > singletons = new HashSet< Object >();

    public SampleApplication()
    {
        singletons.add( new MessageRestService() );
    }

    @Override
    public Set< Class< ? > > getClasses()
    {
        HashSet< Class< ? > > set = new HashSet< Class< ? > >();
        return set;
    }

    @Override
    public Set< Object > getSingletons()
    {
        return singletons;
    }

}