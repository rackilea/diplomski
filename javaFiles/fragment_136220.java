@Autowired
@Qualifier("authenticationManager")
@Override
public void setAuthenticationManager(AuthenticationManager authenticationManager, AuthenticationFailureHandler failureHandler) {
    this.setAuthenticationManager(authenticationManager);
    this.setAuthenticationFailureHandler(failureHandler);
}