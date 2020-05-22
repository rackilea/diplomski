@Override
public void contextInitialized(ServletContextEvent sce) {
    WebApplicationContextUtils
        .getRequiredWebApplicationContext(sce.getServletContext())
        .getAutowireCapableBeanFactory()
        .autowireBean(this);

    //Do something with props
    ...
}