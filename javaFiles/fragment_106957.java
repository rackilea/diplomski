package mypackage;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class MyFilter implements Filter {

    private String pattern;

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // check whether we have a httpServletRequest and a pattern
        if (this.pattern != null && request instanceof HttpServletRequest) {
            // resolve the query string from the httpServletRequest
            String queryString = ((HttpServletRequest) request).getQueryString();
            // check whether a query string exists and matches the given pattern
            if (queryString != null && queryString.matches(pattern)) {
                // TODO do someting special
            }
        }
        chain.doFilter(request, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.pattern = filterConfig.getInitParameter("pattern");
    }

}