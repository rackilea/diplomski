public class BasicAuthenticatedWebSession extends AuthenticatedWebSession {

public static BasicAuthenticatedWebSession get() {
        return (BasicAuthenticatedWebSession ) Session.get();
    }

...
}