private static final Map<Thread, Connection> connections = new ConcurrentHashMap();
public static final ThreadLocal<Connection> CONNECTION = new ThreadLocal<Connection>() {
     public Connection initialValue() {
         LOG.info(Thread.currentThread()+": created a connection.");
         Connection conn = createConnection();
         connections.put(Thread.currentThread(), conn);
         return conn;
     }
};
public static void cleanUp() {
     for(Map.Entry<Thread, Connection> entry: connections.entrySet()) {
         Thread t = entry.getKey();
         if (!t.isAlive()) {
             LOG.info(t+": closed a connection.");
             connections.remove(t);
             entry.getValue().close();
         }
     }
}