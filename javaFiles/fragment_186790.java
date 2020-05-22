public class Resource
{
    private static final ThreadLocal<Resource> threadLocal = new ThreadLocal<Resource>();

    public static Resource getInstance()
    {
        return threadLocal.get();
    }

    public static void setInstance(final Resource instance)
    {
        threadLocal.set(instance);
    }
    ...
}