import java.util.*;
import java.util.logging.*;

public class ResourceManager 
{
    private static final Map<ClassLoader, Map<String, Object>> resources = 
        Collections.synchronizedMap(new WeakHashMap<ClassLoader, Map<String, Object>>());
    public static final String LOGGER = Logger.class.getName();

    static
    {
        // adjust for log4j or other frameworks
        final Logger logger = Logger.getLogger("logging.default");
        logger.setLevel(Level.ALL);
        logger.addHandler(new ConsoleHandler() 
        {
            {
                setOutputStream(System.out);
                setLevel(Level.ALL);
            }
        });
        registerResource(null, LOGGER, logger);
    }

    private static ClassLoader getApplicationScope()
    {
        return Thread.currentThread().getContextClassLoader();
    }

    public static void registerResource(final String name, final Object resource)
    {
        registerResource(getApplicationScope(), name, resource);
    }

    public static synchronized void registerResource(final ClassLoader scope, final String name, final Object resource)
    {
        Map<String, Object> hm = null;
        hm = resources.get(scope);
        if (hm == null)
        {
            hm = Collections.synchronizedMap(new HashMap<String, Object>());
            resources.put(scope, hm);
        }
        hm.put(name, resource);
    }

    public static Object getResource(final String name)
    {
        for(ClassLoader scope = getApplicationScope();;scope = scope.getParent())
        {
            final Map<String, Object> hm = resources.get(scope);
            if ((hm != null) && hm.containsKey(name)) 
            {
                return hm.get(name);
            }
            if (scope == null) break;
        }
        return null;
    }

    public static void registerLogger(final Logger logger)
    {
        registerResource(LOGGER, logger);
    }

    public static Logger getLogger()
    {
        return (Logger)getResource(LOGGER);
    }       
}