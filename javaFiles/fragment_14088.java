public class ExUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

 @Override
 public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
          final String username = request.getParameter("j_username");

          // delegate your logic
          return super.attemptAuthentication(request, response); 
  } 
}