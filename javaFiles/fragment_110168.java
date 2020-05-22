@WebListener
public class Config implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        event.getServletContext().setAttribute("carrierCodes", CarrierCode.values());
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        // NOOP
    }

}