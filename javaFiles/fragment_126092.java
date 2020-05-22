public class KerbHttpServletRequest extends HttpServletRequestWrapper
{
    private Principal myPrincipal;
    private String myAuthType;

    public KerbHttpServletRequest(HttpServletRequest aRequest,
        Principal aPrincipal,
        String aAuthType)
    {
        super(aRequest);
        myPrincipal = aPrincipal;
        myAuthType = aAuthType;
    }

    /**
     * This method returns the Remote User name as user\@domain.com.
     */
    @Override
    public String getRemoteUser()
    {
        return myPrincipal.getName();
    }

    @Override
    public String getAuthType()
    {
        return myAuthType;
    }

    @Override
    public Principal getUserPrincipal()
    {
        return myPrincipal;
    }
}