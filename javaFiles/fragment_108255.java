public static final ThreadLocal<Connection> CONNECTION = new ThreadLocal<Connection>() {
     public Connection initialValue() {
         LOG.info(Thread.currentThread()+": created a connection.");
         return createConnection();
     }
};