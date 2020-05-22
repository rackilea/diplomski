@Component
public class ProtocolServer extends Thread {
  volatile ServerSocket server;
  volatile Socket connection;

  public ProtocolServer() {
    super("Protocol Server on 4100"); // to identify the thread
  }

  @Activate void activate() {
    setDaemon(true);
    start();
  }

  @Deactivate void deactivate() {
     interrupt();

     // best effort close (even if null)
     try { server.close(); } catch(Exception e) {}
     try { connection.close(); } catch(Exception e) {}

     join(10000); // waits 10 secs until thread exits
  }

  public void run() {
    // loop for active component
    while( !isInterrupted() )
    try {
      doServer();
    } catch( Exception e) {
      log(e);

      // bad error, accept failed or bind failed
      // or server socket was closed. If we should remain
      // active, sleep to prevent overloading the
      // system by trying too often, so sleep

      if ( !isInterrupted() )
         try { Thread.sleep(5000); } catch(Exception e) {}
    }
  }

  private void doServer() throws Exception {
      server = new ServerSocket(4100)
      try {
         while( !isInterrupted() )
           doConnection(server);
      } finally {
        server.close();
      }
  }

  private void doConnection(ServerSocket server) throws Exception {
    connection = server.accept();
    try {
      doMessages(connection);

      // the pseudo code exits here, but that seems
      // kind of weird? If desired, interrupt
      // this object, this will exit the thread

    } catch( Exception e) {
       log(e); // the connection failed, is not uncommon
    } finally {
      connection.close();
      connection = null;
    }
  }

  private void doMessages(Socket connection) {
    MyScanner s = new MyScanner(socket);
    String msg;
    while( !isInterrupted() && !"bye".equals( msg=s.getMessage()))
      process(msg);
  }
}