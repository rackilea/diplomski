@Provider
@Priority(Priorities.AUTHENTICATION)
public class SecurityFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        SecurityContext originalContext = requestContext.getSecurityContext();
        Set<String> roles = new HashSet<>();
        roles.add("ADMIN");
        Authorizer authorizer = new Authorizer(roles, "admin", 
                                               originalContext.isSecure());
        requestContext.setSecurityContext(authorizer);
    }

    public static class Authorizer implements SecurityContext {

        Set<String> roles;
        String username;
        boolean isSecure;
        public Authorizer(Set<String> roles, final String username, 
                                             boolean isSecure) {
            this.roles = roles;
            this.username = username;
            this.isSecure = isSecure;
        }

        @Override
        public Principal getUserPrincipal() {
            return new User(username);
        }

        @Override
        public boolean isUserInRole(String role) {
            return roles.contains(role);
        }

        @Override
        public boolean isSecure() {
            return isSecure;
        }

        @Override
        public String getAuthenticationScheme() {
            return "Your Scheme";
        } 
    } 

    public static class User implements Principal {
        String name;

        public User(String name) {
            this.name = name;
        }

        @Override
        public String getName() { return name; }   
    }
}