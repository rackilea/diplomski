public class MyServletContextListener implements ServletContextListener {
    @Override public void contextInitialized(ServletContextEvent event) {
        ServletContext sc = event.getServletContext();
        if ("".equals(sc.getContextPath())) {
            ServletRegistration.Dynamic dreg = sc.addServlet("pageservlet", new PageServlet());
            dreg.addMapping("");
        }
    }
}