public class RootPathHolder implements ServletContextListener {
    static String rootPath;

    public void contextInitialized(ServletContextEvent sce) {
        RootServletListener.rootPath = sce.getServletContext().getRealPath("/");
    }

    public void contextDestroyed(ServletContextEvent sce) {
    }

    public static String getRootPath() {
        return rootPath;
    }
}