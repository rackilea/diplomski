@WebListener
public class Config implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        List<Page> pages = new ArrayList<Page>();
        pages.add(new Page("/home", "Home"));
        pages.add(new Page("/bills", "Bills"));
        // ...
        event.getServletContext().setAttribute("pages", pages);
    }

    // ...
}