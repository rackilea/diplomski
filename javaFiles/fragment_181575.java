@WebFilter("/app/*")
public class LoginFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        //Set init params and load any resources to be used in this class.
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
        throws IOException, ServletException {
        //Here you will pre and post process the request-response cycle.
        //Pre process is before executing "chain.doFilter(req, res);"
        //Post process is after executing "chain.doFilter(req, res);"
        HttpServletRequest request = (HttpServletRequest)req;
        HttpServletResponse response = (HttpServletResponse)res;

        String someRequestHeader = request.getHeader("<header-you-want-or-need>");
        //do what you need to do
        chain.doFilter(req, res);
    }

    @Override
    public void destroy() {
        //Close/free any resources used in this class.
    }

}