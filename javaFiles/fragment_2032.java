public class WaterMarkFilter implements Filter {

    private ServletRequest request;
    private PrintWriter out;
    private CharResponseWrapper wrapper;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
               throws IOException, ServletException {

        this.request = request; 
        out = response.getWriter();
        wrapper = new CharResponseWrapper((HttpServletResponse) response);

        chain.doFilter(request, wrapper);

        postFilter();

        out.close();
    }

    private void postFilter() throws IOException, ServletException {
        String path = ((HttpServletRequest) request).getRequestURI();
        if (canIntercept(path)) {
            out.write(wrapper.toString() + "modified");
        }
        else {
            out.write(wrapper.toString());
        }
    }
}