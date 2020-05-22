@Override
public void contextInitialized(ServletContextEvent event) {

    final WebApplicationContext springContext = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());
    final Properties props = (Properties)springContext.getBean("myProps");
}