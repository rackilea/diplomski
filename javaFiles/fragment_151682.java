public class AuthorizationDynamicFeature implements DynamicFeature {

    @Override
    public void configure(final ResourceInfo resourceInfo, final FeatureContext featureContext) {

        Authorized auth = new AnnotatedMethod(resourceInfo.getResourceMethod()).getAnnotation(Authorized.class);
        if (auth != null) {
            featureContext.register(new AuthorizationRequestFilter(auth.value()));
        }
    }

    @Priority(Priorities.AUTHORIZATION)
    private static class AuthorizationRequestFilter implements ContainerRequestFilter {

        private final String[] roles;

        AuthorizationRequestFilter() {
            this.roles = null;
        }

        AuthorizationRequestFilter(final String[] roles) {
            this.roles = roles;
        }

        @Override
        public void filter(final ContainerRequestContext requestContext) throws IOException {
            if (!this.roles[0].isEmpty()) {
                for (final String role : this.roles) {
                    if (requestContext.getSecurityContext().isUserInRole(role)) {
                        return;
                    }
                }
                throw new ForbiddenException(LocalizationMessages.USER_NOT_AUTHORIZED());
            }
        }
    }
}