public static void main(String[] args) throws Exception {
    final RecordManager recman = createRecordManager(args);

    Server server = new Server(DEFAULT_HTTP_PORT);
    try {

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setWar(WAR_LOCATION);

        webAppContext.addEventListener(new org.jboss.resteasy.plugins.server.servlet.ResteasyBootstrap(){
            @Override
            public void contextInitialized(ServletContextEvent event) {
                super.contextInitialized(event);
                deployment.getDispatcher().getDefaultContextObjects().put(RecordManager.class, recman);
            }
        });

        webAppContext.addServlet(org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher.class, "/*");

        webAppContext.setServer(server);
        server.setHandler(webAppContext);

        server.start();

    } catch (Exception e) {
        logger.error("Error when starting", e);
        server.stop();
    } 
}