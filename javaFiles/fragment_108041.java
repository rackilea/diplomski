@WebListener
final class YourServletContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        EmbeddedEngineHandler.markAsServletContext();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        if (EmbeddedEngineHandler.isLocalEngineLoaded()) {
            EmbeddedEngineHandler.unloadEmbeddedEngine();
        }
    }
}