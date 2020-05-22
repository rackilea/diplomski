public class JettyServer {

    private static final Logger LOGGER = LoggerFactory.getLogger(JettyServer.class);

    public static void main(final String[] args) throws Exception {
        LOGGER.debug("Starting jetty server");
        int port = 8083;
        LOGGER.debug("Setting the port to {}", port);
        final Server server = new Server(port);
        final WebAppContext root = new WebAppContext();
        root.setContextPath("/");
        root.setResourceBase(".");
        EnvConfiguration envConfiguration = new EnvConfiguration();
        envConfiguration.setJettyEnvXml(JettyServer.class.getResource("/WEB-INF/jetty-env.xml").toURI().toURL());
        //Adding the actual classes instead of just the class names
        root.setConfigurations(new Configuration[]{envConfiguration, new PlusConfiguration(), new WebXmlConfiguration()});
        root.setDescriptor(JettyServer.class.getResource("/WEB-INF/web.xml").toString());
        server.setHandler(root);
        server.start();
        server.join();
    }
}