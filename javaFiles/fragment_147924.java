public class UnsafeServlet implements Servlet {

    private int counter;

    public void init(ServletConfig config) throws ServletException {
    }

    public void service(ServletRequest request, ServletResponse response)
        ++counter;
    }

    public void destroy() {
    }

}