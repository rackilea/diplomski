public static class Filter implements ContainerRequestFilter {

    @Context
    private javax.inject.Provider<Request> requestProvider;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        final Request request = requestProvider.get();
        System.out.println(request.getRemoteAddr());
    } 
}