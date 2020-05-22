public Authentication authenticate(Authentication authentication)
    throws AuthenticationException 
{
    try {
        thirdPartyClass.login();
        return new UsernamePasswordAuthenticationToken(
                name, password, new ArrayList<>());
    } catch (ThirdPartyException tpe) {
        throw new AuthenticationException(tpe.getMessage(), tpe);
    }
}