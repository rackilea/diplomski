@Provider 
public class AuditRequestFilter implements ContainerRequestFilter {

    @Context
    private ResourceInfo info;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {

        Class<?> resourceClass = info.getResourceClass();
        Method resourceMethod = info.getResourceMethod();
    }
}