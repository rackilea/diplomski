public class Launcher {

    private static final String RESTEASY_SERVLET_NAME = "resteasy-servlet";

    public static void main(String[] args) throws Exception {
        new Launcher().start();
    }

    void start() throws Exception {

        String port = System.getenv("PORT");
        if (port == null || port.isEmpty()) {
            port = "8080";
        }

        String contextPath = "/api";
        String appBase = ".";

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(Integer.valueOf(port));
        tomcat.getHost().setAppBase(appBase);

        Context context = tomcat.addContext(contextPath, appBase);
        context.addApplicationListener(ResteasyBootstrap.class.getName());
        Tomcat.addServlet(context, RESTEASY_SERVLET_NAME, new HttpServletDispatcher());
        context.addParameter("javax.ws.rs.Application", MyApplication.class.getName());
        context.addServletMappingDecoded("/*", RESTEASY_SERVLET_NAME);

        tomcat.start();
        tomcat.getServer().await();
    }
}