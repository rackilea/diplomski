public void filter(ContainerRequestContext requestContext) {

        final ExtendedUriInfo extendendUriInfo = (ExtendedUriInfo) requestContext.getUriInfo();

        boolean checkAccountStatus = extendendUriInfo
                                                    .getMatchedResourceMethod()
                                                    .getInvocable()
                                                    .getHandlingMethod()
                                                    .getAnnotation(AuthenticationFilterBinding.class).checkAccountStatus();
}