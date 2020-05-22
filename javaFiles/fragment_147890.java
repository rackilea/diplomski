@Priority(Priorities.AUTHORIZATION) // filter deals with roles, comes after AUTHENTICATION
public class RestContextFilter implements ContainerRequestFilter
{
    // you need to inject a provider, rather than the class directly
    // because this filter is instantiated before the request scope is ready
    private Provider<RestContext> rcProvider;

    @Inject
    public RestContextFilter(Provider<RestContext> rcProvider)
    {
        this.rcProvider = rcProvider;
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException
    {
        // now you're in a request scope and can get your context
        RestContext rc = rcProvider.get();

        // set some properties on rc here (current user or roles or whatever)
    }
}