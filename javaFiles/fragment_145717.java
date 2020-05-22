@Component
public class HttpAuthenticationPoint implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
            AuthenticationException authException) throws IOException {
        response.sendRedirect(request.getContextPath()+"/getFrontPage.html");

    }
}