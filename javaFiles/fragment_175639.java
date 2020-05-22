import javax.ws.rs.core.Application;
import javax.ws.rs.ApplicationPath;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/rest")
public class RESTConfig extends Application
{

    public RESTConfig(){}

    @Override
    public Set<Class<?>> getClasses( )
    {
        final Set<Class<?>> returnValue = new HashSet<Class<?>>( );
        returnValue.add( Account.class );
        return returnValue;
    }
}