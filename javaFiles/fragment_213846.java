private static final String DEFAULT_MESSAGE = "Hello, World!";
private static final String DEFAULT_CONNECTION_FACTORY = "jms/RemoteConnectionFactory";
private static final String DEFAULT_DESTINATION = "jms/queue/test";
private static final String DEFAULT_MESSAGE_COUNT = "1";
private static final String DEFAULT_USERNAME = "quickstartUser";
private static final String DEFAULT_PASSWORD = "quickstartPwd1!";
private static final String INITIAL_CONTEXT_FACTORY = "org.jboss.naming.remote.client.InitialContextFactory";
private static final String PROVIDER_URL = "remote://localhost:4447";

String connectionFactoryString = System.getProperty("connection.factory", DEFAULT_CONNECTION_FACTORY);
log.info("Attempting to acquire connection factory \"" + connectionFactoryString + "\"");
connectionFactory = (ConnectionFactory) context.lookup(connectionFactoryString);
log.info("Found connection factory \"" + connectionFactoryString + "\" in JNDI");