public class MyProject extends AuthenticatedWebApplication
{
    ...

@Override
    public Session newSession(Request request, Response response) {
        return new BasicAuthenticatedWebSession (request);
    }
}