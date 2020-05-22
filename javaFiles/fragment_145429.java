@WebListener
public class ServletContextListenerImpl implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ReportData m_myData = new ReportData ();
        System.out.println("My ServletContextListenerImpl has been initialized");

        // then add to your session for later use
        sce.getServletContext().setAttribute("RDATA", m_myData);
    }
    ..
 }