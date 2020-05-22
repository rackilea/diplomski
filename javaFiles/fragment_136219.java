@Bean
public AuthenticationFailureHandler getFailureHandler(){
  SimpleUrlAuthenticationFailureHandler handler  =  new SimpleUrlAuthenticationFailureHandler();
  handler.setDefaultFailureUrl("/login.html");
  return handler;
}