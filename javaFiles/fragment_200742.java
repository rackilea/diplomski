@ManagedBean
public class DynServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @EJB
    private LoginService loginService;

    public DynServlet() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        response.getOutputStream().println(
                "Request made to: " + getClass().getSimpleName());
        response.getOutputStream().println("Login Service: " + loginService);

        return;
    }
}

@WebListener
public class DynamicServletLoadListener implements ServletContextListener {

    public DynamicServletLoadListener() {
        super();
    }

    @Override
    public void contextDestroyed(final ServletContextEvent contextEvent) {
        return;
    }

    @Override
    public void contextInitialized(final ServletContextEvent contextEvent) {
        contextEvent.getServletContext().addServlet("dynservlet", DynServlet.class)
                .addMapping("/services/dynservlet");
    }
}