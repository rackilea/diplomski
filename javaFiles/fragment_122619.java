@WebFilter(urlPatterns = "/login.jsp")
public class SecurityFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        final String loginType = request.getParameter("login-type");

        final HttpServletResponse servletResponse = (HttpServletResponse) response;
        if ("sso".equalsIgnoreCase(loginType)) {
            final String redirectUrl = "sso.jsp";
            servletResponse.sendRedirect(redirectUrl);
        } else {
            chain.doFilter(request, response);
        }
    }

}