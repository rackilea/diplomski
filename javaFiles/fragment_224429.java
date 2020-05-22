// Stop the server.
new Thread()
{
   public void run() {
     try {
        log.info("Shutting down the server...");
        server.stop();
        log.info("Server has stopped.");
     } catch (Exception ex) {
        log.error("Error when stopping Jetty server: "+ex.getMessage(), ex);
     }
   }
}.start();