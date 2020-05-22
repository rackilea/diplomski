@Override
public void init(AuthenticationManagerBuilder auth) throws Exception
{
    auth.userDetailsService(getUserDetailsService());
}

@Bean
UserDetailsService getUserDetailsService() {
  return username ->
  {
    JSONObject user = callUserService(username); //Here you send the UserRequest
    if(user.has("email")) {
       return new User(
         user.getString("email"),
         user.getString("password"),
         true, true, true, true,
         Collections.emptyList());
     } else {
          throw new BadCredentialsException("BadCredentialsException");
      }
    };
 }