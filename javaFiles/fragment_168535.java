import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class ExampleFilter implements Filter {

    @Override
    public void init(FilterConfig fc) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, 
                        FilterChain fc) throws IOException, ServletException {

        // Needed for getting URL from request
        final HttpServletRequest hsRequest = (HttpServletRequest) request;
        String url = hsRequest.getRequestURI().substring(
                        hsRequest.getContextPath().length()
                     );

        /* This is just simple example. Here you can connect to database
           or read properties or XML file with your configuration */
        if ("/de/pagina".equals(url) || "/en/page".equals(url)) {
            // change url and forward 
            RequestDispatcher dispatcher = request.getRequestDispatcher("/page");
            dispatcher.forward(request, response);
        } else {
            // Do nothing, just send request and response to other filters
            fc.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {}
}