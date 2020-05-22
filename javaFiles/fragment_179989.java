public class ExampleAuthorizer implements Authorizer<ExamplePrincipal> {

    @Override
    public boolean authorize(ExamplePrincipal principal, String role) {
        return principal.getRoles().contains(role);
    }
}