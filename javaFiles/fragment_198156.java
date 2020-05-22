@Override
public void contextInitialized(ServletContextEvent sce) {
    Config config = ConfigProvider.getConfig();
    String projectStage = config.getValue("javax.faces.PROJECT_STAGE", String.class);
    sce.getServletContext().setInitParameter("javax.faces.PROJECT_STAGE", projectStage);
}