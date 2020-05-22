public class CustomBootstrapCacheLoaderFactory extends BootstrapCacheLoaderFactor
{
.
.
@Override
public BootstrapCacheLoader createBootstrapCacheLoader(Properties properties)
{
    CustomBootstrapCacheLoader loader = new CustomBootstrapCacheLoader();
    loader.setAsynchronous(getAsyncFromProperty(properties));

    return loader;
}
.
.
}