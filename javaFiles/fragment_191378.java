@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        X509Certificate[] certificates = (X509Certificate[]) requestContext.getProperty("javax.servlet.request.X509Certificate");
        Principal principal = certificates[0].getSubjectX500Principal();
    }

}