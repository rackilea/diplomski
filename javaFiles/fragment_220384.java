@Component
public class CustomAuthenticationFailureHandler implements AuthenticationFailureHandler
{
    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException
    {
        response.sendRedirect(request.getContextPath() + "/login?error=true");
    }   
}

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler
{
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException
    {
        HttpSession session = request.getSession();
        if (session != null)
        {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
        response.sendRedirect(request.getContextPath() + "/app/user/dashboard");
    }
}