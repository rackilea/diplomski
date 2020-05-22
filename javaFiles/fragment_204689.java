public class ServletDelegatingController implements ServletConfig {
    private final DelegateServlet delegate = new DelegateServlet();

    public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception { 
        delegate.service(request, response);
    }



    // properly initializes the servlet
    public void setServletConfig(ServletConfig servletConfig) {
        try {
            delegate.init(servletConfig);
        } catch (ServletException e) {
            throw new IllegalStateException("Failure while initializing the servlet", e);
        }
    }
}