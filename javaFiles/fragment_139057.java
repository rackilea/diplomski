public class RestletApplication extends Application {
    (...)

    @Override
    public Restlet createInboundRoot() {
        Router router = new Router(getContext());
        (...)

        ChallengeAuthenticator guard = new ChallengeAuthenticator(
                null, ChallengeScheme.HTTP_BASIC, "testRealm");
        (...)
        guard.setNext(router);

        Filter filter = new SecurityPostProcessingFilter(
             getContext(), guard);

        return filter;
    }
}