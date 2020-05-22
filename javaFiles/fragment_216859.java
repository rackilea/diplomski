@WebFilter(filterName = "MyCustomFilter")
public class MyCustomFilter implements Filter {

    @Override
    public void destroy() {
        // TODO Auto-generated method stub

    }

    @Override
    public void doFilter(ServletRequest arg0, ServletResponse arg1,
            FilterChain arg2) throws IOException, ServletException {
        try {
            String url = ((HttpServletRequest)arg0).getRequestURI();
            //Take into account thet the url here would be the complete url. I just put an example taking into account
            //your application name is JAX-RS_tutorial
            String redirect = url.substring("/JAX-RS_tutorial/v1".length(), url.length());
            arg0.getRequestDispatcher(redirect).forward(arg0, arg1);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            throw new ServletException(e);
        }

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {
        // TODO Auto-generated method stub

    }

}