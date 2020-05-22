public class SecurityFilter extends OncePerRequestFilter{
@Override
protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException{
String accessToken = request.getHeader("Authorization");
// Do stuff here based on the access token (check for user's authorization to the resource ...
}