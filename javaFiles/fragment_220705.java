class ConnectionWrapper {
   private Connection connection;
   private int users = 0;
   private boolean expiredFromCache = false;
   public Connection acquire() { users++; return connection; }
   public void release() {
     users--;
     if (users == 0 && expiredFromCache) {
       // The cache expired this connection.
       // We're the only ones still holding on to it.
     }
   }
   synchronized void tearDown() {
     connection.tearDown();
     connection = null; // disable myself
   }

 }