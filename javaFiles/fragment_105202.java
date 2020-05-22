@Component
public class AuthenticationSuccessHandlerImpl implements AuthenticationSuccessHandler {
    Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
            Authentication authentication) throws IOException, ServletException {
        request.getSession().setAttribute("someDetail", "detailsValue");
        response.sendRedirect("/to-whatever-url-you-want")
    }
}