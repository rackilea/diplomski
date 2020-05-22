@WebListener
public class AppListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent e) {
        Uber uber = new Uber();
        /* configure uber */
        //store it in ServletContext
        e.getServletContext().setAttribute("uber", uber);
    }
    @Override
    public void contextDestroyed(ServletContextEvent e) {
        //...
    }
}