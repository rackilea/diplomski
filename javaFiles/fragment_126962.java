public class TrailerProductModelUrlResolver extends DefaultProductModelUrlResolver
{

    private static final Logger LOG = Logger.getLogger(TrailerProductModelUrlResolver.class);
    @Override
    protected String resolveInternal(final ProductModel source)
    {
        final ProductModel baseProduct = getBaseProduct(source);
        ...
    }
}