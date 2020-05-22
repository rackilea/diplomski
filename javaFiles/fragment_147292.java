public class ThirdPartyAuthenticationProvider implements AuthenticationProvider {

    private Class<? extends Authentication> supportingClass = UsernamePasswordAuthenticationToken.class;

    // This represents your existing username/password validation class
    // Bind it with an @Autowired or set it in your security config
    private ExternalAuthenticationValidator externalAuthenticationValidator;

    /* (non-Javadoc)
     * @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        boolean validated = this.externalAuthenticationValidator.validate(authentication.getName(), authentication.getCredentials().toString());
        if(!validated){
            throw new BadCredentialsException("username and/or password not valid");
        }
        Collection<? extends GrantedAuthority> authorities = null; 
        // you must fill this authorities collection
        return new UsernamePasswordAuthenticationToken(
                    authentication.getName(),
                    authentication.getCredentials(),
                    authorities
                );      
    }

    /* (non-Javadoc)
     * @see org.springframework.security.authentication.AuthenticationProvider#supports(java.lang.Class)
     */
    @Override
    public boolean supports(Class<?> authentication) {
        return this.supportingClass.isAssignableFrom(authentication);
    }

    public ExternalAuthenticationValidator getExternalAuthenticationValidator() {
        return externalAuthenticationValidator;
    }

    public void setExternalAuthenticationValidator(ExternalAuthenticationValidator externalAuthenticationValidator) {
        this.externalAuthenticationValidator = externalAuthenticationValidator;
    }   

}