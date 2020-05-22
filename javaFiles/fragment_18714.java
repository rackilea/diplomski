import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class YourFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res,
            FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;

        if (request.getRequestHeader("Accept").contains("application/json")) {
            chain.doFilter(req, res);
        } else {
            ((HttpServletResponse)response).setStatus(SC_NOT_ACCEPTABLE);
        }
    }
    public void init(FilterConfig config) throws ServletException {
         // any startup stuff here if needed
    }
    public void destroy() {
        // add code to release any resource
    }
}