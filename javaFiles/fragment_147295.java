public class ThirdPartyAuthenticationProvider implements AuthenticationProvider {

    private Class<? extends Authentication> supportingClass = UsernamePasswordAuthenticationToken.class;

    private ExternalAuthenticationValidator externalAuthenticationValidator;

    /* (non-Javadoc)
     * @see org.springframework.security.authentication.AuthenticationProvider#authenticate(org.springframework.security.core.Authentication)
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        ThirdPartyValidationResponse response = this.externalAuthenticationValidator.validate(authentication.getName(), authentication.getCredentials().toString());
        if(!response.isValid()){
            throw new BadCredentialsException("username and/or password not valid");
        }
        Collection<? extends GrantedAuthority> authorities = null; 
        // you must fill this authorities collection
        UsernamePasswordAuthenticationToken authenticated =  
                new UsernamePasswordAuthenticationToken(
                    authentication.getName(),
                    authentication.getCredentials(),
                    authorities
                );
        authenticated.setDetails(response);
        return authenticated;
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