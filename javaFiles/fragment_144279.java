public class UrlerResourceTest extends JerseyTest {
    ...
    @Override
    public Application configure() {
        return new ResourceConfig(FooResource.class)
                .register(AuthorizationRequestFilter.class)
                .register(AuthenticationFilter.class);
    }

    @Provider
    @Priority(Priorities.AUTHENTICATION)
    public static class AuthenticationFilter implements ContainerRequestFilter {
        @Override
        public void filter(ContainerRequestContext requestContext) throws IOException {
            requestContext.setSecurityContext(new SecurityContext() {
                @Override
                public Principal getUserPrincipal() {
                    return new Principal() {
                        @Override
                        public String getName() {
                            return "Stackoverflow";
                        }
                    };
                }
                @Override
                public boolean isUserInRole(String string) {
                    return "privileged".equals(string);
                }
                @Override
                public boolean isSecure() { return true; }
                @Override
                public String getAuthenticationScheme() { return "BASIC"; }                
            });
        }  
    }
    ...   
}