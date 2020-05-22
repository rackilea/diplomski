public class WebAppPropertiesListener implements ServletContextListener{
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        String rootPath = sce.getServletContext().getRealPath("/");
        System.setProperty("webroot", rootPath);

    }
    ...
 }