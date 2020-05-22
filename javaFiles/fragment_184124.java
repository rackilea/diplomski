public static void main(String... args) throws IOException {
    ServerSocket serverSock = new ServerSocket(9999);
    ExecutorService es = Executors.newCachedThreadPool();
    while (true)
      es.submit(new ClientHandler(serverSock.accept()));
  }
}
class ClientHandler implements Runnable {
  private final Socket socket;
  public ClientHandler(Socket socket) { this.socket = socket; }

  public void run()  {
    while(true) {
       // do something with the socket. 
    }
  }
}