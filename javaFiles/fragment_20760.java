package com.example.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet Filter implementation class RoleCheckFilter.
 * Its purpose is to check logged-in user's role and
 * and accordingly allow or prevent access to the web resources.
 */
public class RoleCheckFilter implements Filter {

    /**
     * @see Filter#init(FilterConfig)
     */
    public void init(FilterConfig filterConfig) throws ServletException {}

    /**
     * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
     */
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
                throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        if (request.isUserInRole("admin")) {
            // user have the appropriate rights, allow the request
            chain.doFilter(request, response);
        } else {
            // user does not have the appropriate rights, do something about it
            request.setAttribute("error", "You don't have enough rights to access this resource");
            response.sendRedirect(request.getContextPath() + "/login.jsp");
            // or you could forward a user request somewhere
        }
    }


    /**
     * @see Filter#destroy()
     */
    public void destroy() {}

}