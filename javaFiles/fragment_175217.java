public class CustomJaspiAuthModule extends WebServerAuthModule 
{
    private static final String CLASSNAME   = "CustomJaspiAuthModule";
    private static Logger       logger      = Logger.getLogger(CustomJaspiAuthModule.class.getName());

    protected Context context;
    protected String delegatingLoginContextName = null;

    public CustomJaspiAuthModule() { }

    public CustomJaspiAuthModule(String delegatingLoginContextName) 
    {
        super();
        this.delegatingLoginContextName = delegatingLoginContextName;
    }

    @Override
    public AuthStatus secureResponse(MessageInfo messageInfo, Subject serviceSubject) throws AuthException 
    {
        // do nothing, just return SUCCESS.
        return AuthStatus.SUCCESS;
    }

    @Override
    public AuthStatus validateRequest(MessageInfo messageInfo, Subject clientSubject, Subject serviceSubject) throws AuthException 
    {
        final String METHOD_NAME = "validateRequest";
        logger.logp(Level.INFO, CLASSNAME, METHOD_NAME, "**IN AUTHENTICATION MODULE**CustomJaspiAuthModule.validateRequest()");

        Request request = (Request) messageInfo.getRequestMessage();
        Response response = (Response) messageInfo.getResponseMessage();

        boolean authenticated = false;
        context = request.getContext();
        Principal principal = context.getRealm().authenticate("*", "*");

        Callback[] callbacks = new Callback[] {
                new CallerPrincipalCallback(clientSubject, (Principal) null) };

        if (principal != null) 
        {
            callbacks = new Callback[] { 
                    new CallerPrincipalCallback(clientSubject, principal) };
            authenticated = true;
        } 

        if (authenticated) 
        {
            try 
            {
                callbackHandler.handle(callbacks);
            } 
            catch (final Exception e) 
            {
                throw (AuthException) new AuthException().initCause(e);
            }
            return AuthStatus.SUCCESS;
        }

        return AuthStatus.FAILURE;
    }
}