public class OpenFacesResourceFilter extends ResourceFilter {
    // -- Fields --

    // -- Methods --
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try{
            super.doFilter(servletRequest, servletResponse, filterChain);
        } catch (ServletException e) {
            Throwable parent = e.getCause();
            if(parent!=null && parent instanceof ServletException) {
                throw (ServletException) parent;
            } else {
                throw e;
            }
        }
    }
}