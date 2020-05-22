@Component
@Provider
@Priority(value = 2)
public class CorsResponseFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext)
            throws IOException {

        System.out.println("filtered");
    }

}