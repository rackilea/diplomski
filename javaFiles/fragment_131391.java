public class ThreadNameFilter implements javax.servlet.Filter { 

    public void doFilter(ServletRequest req, ServletResponse resp, 
        FilterChain fc) throws IOException, ServletException { 

        HttpServletRequest httpReq = (HttpServletRequest)req; 
        final Thread curThr = Thread.currentThread(); 
        final String oldName = curThr.getName(); 

        // change the name of the current thread to something related
        // to the application (e.g. URI)
        try { 
            curThr.setName(httpReq.getRequestURI()); 
            fc.doFilter(req, resp); 
        } finally { 
            curThr.setName(oldName); 
        } 
    } 
}