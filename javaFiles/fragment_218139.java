public class UrlBasedAuthzFilter extends AuthorizationFilter {

    @Override
    public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
        if (request.getServletContext().getContextPath().startsWith("/rest"){
            return false;
        }
        return super.isAccessAllowed(request, response, mappedValue);
    }
}