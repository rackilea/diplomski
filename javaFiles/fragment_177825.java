Hashtable env = new Hashtable();
env.put(Context.INITIAL_CONTEXT_FACTORY, "org.jnp.interfaces.NamingContextFactory");
env.put(Context.PROVIDER_URL, "jnp://localhost:1099");
env.put(Context.URL_PKG_PREFIXES, "org.jboss.naming:org.jnp.interfaces");

Context ctx = new InitialContext(env);
ConnectionFactory cf = (ConnectionFactory)ctx.lookup("/ConnectionFactory");
Queue queue = (Queue)ic.lookup("/queues/MyQueue");
Connection connection = cf.createConnection();
Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
MessageProducer producer = session.createProducer(queue);
connection.start();
TextMessage message = session.createTextMessage("Test");
producer.send(message);