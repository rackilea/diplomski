init() {
//...ommited some not related code
CompoundAuthorizationStrategy compoundAuthorizationStrategy = new CompoundAuthorizationStrategy();
IAuthorizationStrategy membertPageAuthStrategy = new SimplePageAuthorizationStrategy( MemberTemplatePage.class,
        HomePage.class )
{
    @Override
    protected boolean isAuthorized()
    {
        if ( /* user not authorized */ )
            {
                throw new RestartResponseAtInterceptPageException( HomePage.class );
            }
            return true;
    }
};

IAuthorizationStrategy adminPageAuthStrategy = new SimplePageAuthorizationStrategy( AdminTemplatePage.class,
        AdminLoginPage.class )
{
    @Override
    protected boolean isAuthorized()
    {
        if ( /* user not authorized */ )
            {
                throw new RestartResponseAtInterceptPageException( AdminLoginPage.class );
            }
            return true;
    }
};

compoundAuthorizationStrategy.add( membertPageAuthStrategy );
compoundAuthorizationStrategy.add( adminPageAuthStrategy );

getSecuritySettings().setAuthorizationStrategy( compoundAuthorizationStrategy );
//...
}